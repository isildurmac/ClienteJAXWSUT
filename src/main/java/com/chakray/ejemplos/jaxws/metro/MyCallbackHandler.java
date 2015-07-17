package com.chakray.ejemplos.jaxws.metro;

import java.io.IOException;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;

public class MyCallbackHandler implements CallbackHandler {
   
   public void handle(Callback[] callbacks) throws IOException,
      UnsupportedCallbackException {
         for (int i = 0; i < callbacks.length; i++) {
            if (callbacks[i] instanceof NameCallback) {
               NameCallback nc = (NameCallback) callbacks[i];
               nc.setName("admin");
            } else if (callbacks[i] instanceof PasswordCallback) {
               PasswordCallback pc = (PasswordCallback) callbacks[i];
               pc.setPassword("admin".toCharArray());
            } else {
               throw new UnsupportedCallbackException(callbacks[i],
                  "Unrecognized Callback");
            }
         }
   }
}

