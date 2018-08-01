package SpringIoC;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * @author liubaoqing
 * @createTime 2018-07-30
 * @description
 */
@Scope("prototype")
@Repository
public class UserDao implements IUserDao {
}
