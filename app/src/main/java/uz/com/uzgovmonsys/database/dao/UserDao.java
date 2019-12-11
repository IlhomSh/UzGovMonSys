package uz.com.uzgovmonsys.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import io.reactivex.Single;
import uz.com.uzgovmonsys.database.entity.User;

@Dao
public abstract class UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insertUser(User user);

    @Query("SELECT * FROM user WHERE isLogin=1 LIMIT 1")
    public abstract Single<User> getUser();

}
