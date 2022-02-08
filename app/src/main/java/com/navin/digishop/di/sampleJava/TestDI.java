package com.navin.digishop.di.sampleJava;

public class TestDI {


    public void test() {

      UserComponent component =DaggerUserComponent.builder()
              .userModule(new UserModule()).build();

      component.provideUser().setUserContact("Test@gmail.com");
      component.provideUser().getUserContact();
      component.provideUser().deleteUserMail();


    }


}
