package com.navin.digishop.di.sampleJava;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class UserModule {

    @Singleton
    @Provides
    public User provideUser() {
        return new User(new Contact());
    }

    @Singleton
    @Provides
    public Contact provideContact() {
        return new Contact();
    }

}
