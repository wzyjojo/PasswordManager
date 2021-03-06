package com.wzy.pdmanager;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "ACCOUNT_INFO".
*/
public class AccountInfoDao extends AbstractDao<AccountInfo, Long> {

    public static final String TABLENAME = "ACCOUNT_INFO";

    /**
     * Properties of entity AccountInfo.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Title = new Property(1, String.class, "Title", false, "TITLE");
        public final static Property ICO = new Property(2, Integer.class, "ICO", false, "ICO");
        public final static Property Type = new Property(3, Integer.class, "Type", false, "TYPE");
        public final static Property Account = new Property(4, String.class, "Account", false, "ACCOUNT");
        public final static Property Password = new Property(5, String.class, "Password", false, "PASSWORD");
        public final static Property Note = new Property(6, String.class, "Note", false, "NOTE");
        public final static Property Favorite = new Property(7, String.class, "Favorite", false, "FAVORITE");
        public final static Property AddDate = new Property(8, java.util.Date.class, "AddDate", false, "ADD_DATE");
    };


    public AccountInfoDao(DaoConfig config) {
        super(config);
    }
    
    public AccountInfoDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"ACCOUNT_INFO\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"TITLE\" TEXT," + // 1: Title
                "\"ICO\" INTEGER," + // 2: ICO
                "\"TYPE\" INTEGER," + // 3: Type
                "\"ACCOUNT\" TEXT," + // 4: Account
                "\"PASSWORD\" TEXT," + // 5: Password
                "\"NOTE\" TEXT," + // 6: Note
                "\"FAVORITE\" TEXT," + // 7: Favorite
                "\"ADD_DATE\" INTEGER);"); // 8: AddDate
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"ACCOUNT_INFO\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, AccountInfo entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String Title = entity.getTitle();
        if (Title != null) {
            stmt.bindString(2, Title);
        }
 
        Integer ICO = entity.getICO();
        if (ICO != null) {
            stmt.bindLong(3, ICO);
        }
 
        Integer Type = entity.getType();
        if (Type != null) {
            stmt.bindLong(4, Type);
        }
 
        String Account = entity.getAccount();
        if (Account != null) {
            stmt.bindString(5, Account);
        }
 
        String Password = entity.getPassword();
        if (Password != null) {
            stmt.bindString(6, Password);
        }
 
        String Note = entity.getNote();
        if (Note != null) {
            stmt.bindString(7, Note);
        }
 
        String Favorite = entity.getFavorite();
        if (Favorite != null) {
            stmt.bindString(8, Favorite);
        }
 
        java.util.Date AddDate = entity.getAddDate();
        if (AddDate != null) {
            stmt.bindLong(9, AddDate.getTime());
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public AccountInfo readEntity(Cursor cursor, int offset) {
        AccountInfo entity = new AccountInfo( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // Title
            cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2), // ICO
            cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3), // Type
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // Account
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // Password
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // Note
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // Favorite
            cursor.isNull(offset + 8) ? null : new java.util.Date(cursor.getLong(offset + 8)) // AddDate
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, AccountInfo entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setTitle(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setICO(cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2));
        entity.setType(cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3));
        entity.setAccount(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setPassword(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setNote(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setFavorite(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setAddDate(cursor.isNull(offset + 8) ? null : new java.util.Date(cursor.getLong(offset + 8)));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(AccountInfo entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(AccountInfo entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}
