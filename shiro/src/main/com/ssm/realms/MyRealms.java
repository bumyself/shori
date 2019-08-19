package ssm.realms;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.Realm;

public  class MyRealms extends AuthenticatingRealm {
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {




            //1. 把 AuthenticationToken 转换为 UsernamePasswordToken
            UsernamePasswordToken upToken = (UsernamePasswordToken) authenticationToken;

            //2. 从 UsernamePasswordToken 中来获取 username
            String username = upToken.getUsername();

            //3. 调用数据库的方法, 从数据库中查询 username 对应的用户记录
            System.out.println("从数据库中获取 username: " + username + " 所对应的用户信息.");

            //4. 若用户不存在, 则可以抛出 UnknownAccountException 异常
            if("unknown".equals(username)){
                throw new UnknownAccountException("用户不存在!");
            }

            //5. 根据用户信息的情况, 决定是否需要抛出其他的 AuthenticationException 异常.
            if("monster".equals(username)){
                throw new LockedAccountException("用户被锁定");
            }

            Object principal = username;
            Object credentials = "123456";
            String realmName = getName();
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal, credentials,realmName);

            return info;
        }
}
