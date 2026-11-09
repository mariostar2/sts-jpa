package com.example.jpa00.controller;


import com.example.jpa00.entity.MemberEntity;
import com.example.jpa00.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class MyController {


  @Autowired
  private MemberRepository memberRepository;

    @RequestMapping("/")
    public String root(Model model){
        System.out.println("root...............");
        model.addAttribute("msg","Hello Java");
        return "index";
    }

    @RequestMapping("/list")
    public String list(Model model){
        System.out.println("list.......");
        List<MemberEntity> list = memberRepository.findAll();
        model.addAttribute("list",list);
        System.out.println("list......" + list.size());
        //model.addAttribute("list",memberRepository.findAll());
        return "list";
    }
    @RequestMapping("/one")
    public String getMember(Model model ,@RequestParam("id") String id){
        //MemberEntity에 @id를 찾겠다는 부분
        //Optional<MemberEntity> result = memberRepository.findById(id);
        //MemberEntity member = result.get();
        MemberEntity member =memberRepository.findById(id).orElseThrow();
        model.addAttribute("member",member);
        return "detail";
    }
    @RequestMapping("/regist")
    public String regist(MemberEntity member){
        System.out.println("regist.........");
        memberRepository.save(member);

        return "redirect:/list";
    }
    @RequestMapping("/registForm")
    public String registForm(){
        return "regist";
    }


    @RequestMapping("/delete")
    public String delete(@RequestParam("id") String id){
        System.out.println("삭제...............");
        memberRepository.deleteById(id);
        return "redirect:/list";
    }

    @RequestMapping("/update")
    public String update(){
        System.out.println("변경..........");
        MemberEntity member = new MemberEntity();
        member.setMemberId("ccc");
        member.setPw("c1234");
        member.setName("Zero");
        memberRepository.save(member);
        return "redirect:/list";
    }

    @RequestMapping("/updateForm")
    public String updateForm(){
        return "update";
    }


}
