package com.magicsu.criminalintent.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.magicsu.criminalintent.database.CrimeDbSchema.CrimeTable;
import com.magicsu.criminalintent.model.Crime;

import java.util.Date;
import java.util.UUID;

/**
 * Created by admin on 2017/11/15.
 */

public class CrimeCursorWrapper extends CursorWrapper {
    public CrimeCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Crime getCrime() {
        String uuidString = getString(getColumnIndex(CrimeTable.Cols.UUID));
        String  title = getString(getColumnIndex(CrimeTable.Cols.TITLE));
        long date = getLong(getColumnIndex(CrimeTable.Cols.DATE));
        int isSolved = getInt(getColumnIndex(CrimeTable.Cols.SOLVED));
        String suspect = getString(getColumnIndex(CrimeTable.Cols.SUSPECT));
        String phoneNumber = getString(getColumnIndex(CrimeTable.Cols.PHONE_NUMBER));

        Crime crime = new Crime(UUID.fromString(uuidString));
        crime.setTitle(title);
        crime.setDate(new Date(date));
        crime.setSolved(isSolved != 0);
        crime.setSuspect(suspect);
        crime.setPhoneNumber(phoneNumber);
        return crime;
    }
}
