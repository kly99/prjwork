package controller;

import java.util.List;

import javax.validation.Valid;

import logic.UserLogic;

import org.hibernate.validator.constraints.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pbean.UserInfo;
import vbean.VUserInfo;

@Controller
public class UserInsertController {
   @Autowired
   private UserLogic userLogic;

   @RequestMapping(value = "/signUp.html", method = RequestMethod.GET)
   public String signUp(Model model) {
      model.addAttribute("signUpForm", new VUserInfo());
      return "signUp";
   }

   @RequestMapping(value = "/signUp.html", method = RequestMethod.POST)
   public String onSubmit( @Valid @ModelAttribute("signUpForm") VUserInfo signUpForm,
      BindingResult result,Model model) { //모델어트리뷰트 값이 디폴트라면 VUserInfo vuserInfo로 파라미터 생성된다. 그 값은 jsp 폼에러 값
      // 일반에러가 발생하면 돌아간다
      if (result.hasErrors()) {
         System.out.println("회원가입실패");
         model.addAttribute("signUpForm",signUpForm);
         return "signUp";
      }
      //사용자 처리 에러(아이디중복체크)
      List<UserInfo> list= this.userLogic.searchByIdAjax(signUpForm.getUserid());
      if(list.size()>0){
         result.rejectValue("userid","userid.dup",null,"아이디가 중복되었습니다.");
         //(받아올값,메시지프로퍼티,없으면,대체메세지)
           model.addAttribute("signUpForm", signUpForm);
         return "signUp";
      }
      // 에러가 발생하지 않으면 회원가입 처리.
      System.out.println("회원가입완료.");
      this.userLogic.addUser(signUpForm);
      return "redirect:/login.html";
   }

}