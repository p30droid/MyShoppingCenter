package com.navin.digishop.di.sampleJava;


import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = UserModule.class)
public interface UserComponent {


    User provideUser();
}
