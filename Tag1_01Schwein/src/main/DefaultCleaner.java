package main;

import java.lang.ref.Cleaner;

public class DefaultCleaner {

    public static final Cleaner INSTANCE = Cleaner.create();


    private DefaultCleaner() {}
}
