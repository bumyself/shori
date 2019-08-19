package ssm.controller;

import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/shiro")
public class Login {

    @RequestMapping("/login")
    public String login(@RequestParam("username")String username, @RequestParam("password")String password){
        Subject currentUser = SecurityUtils.getSubject();
        if(!(  currentUser).isAuthenticated()){
            UsernamePasswordToken token = new UsernamePasswordToken(username,password);
            token.setRememberMe(true);

            try{
                currentUser.login(token);
                System.out.println("验证成功");
                return "redirect:index.jsp";
            }catch (AuthenticationException ae){
                System.out.println("登录失败");
            }
        }
        return  null;
    }

}
