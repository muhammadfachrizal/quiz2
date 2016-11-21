package com.example.pustikom.adapterplay;

import android.provider.BaseColumns;

/**
 * Created by M. FACHRIZAL on 11/21/2016.
 */

public final class StudentContract {
    private StudentContract(){}

    public static final class StudentEntry implements BaseColumns {

        /**
         * Name of database table for pets
         */
        public final static String TABLE_NAME = "student";
        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_STUDENT_Noreg ="noreg";
        public final static String COLUMN_STUDENT_Nama ="nama";
        public final static String COLUMN_STUDENT_Email ="email";
        public final static String COLUMN_STUDENT_Phone ="phone";
        public final static String COLUMN_STUDENT_Gender ="gender";


    }}
