package hello_review.hellospring_review.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {


    @GetMapping("hello")
    public String hello(Model model)
    {
        model.addAttribute("data", "hello!!");

        return "hello";
    }


    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name")String name, Model model)
    {
        model.addAttribute("name", name);

        return "hello-template";
    }



    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name")String name)
    {
        return "hello " + name;
    }


    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("이름")String name)
    {
        Hello hello = new Hello();
        hello.set이름(name);

        return hello;
    }

    static class Hello
    {
        private String 이름 ;

        public String get이름() {
            return 이름;
        }

        public void set이름(String 이름) {
            this.이름 = 이름;
        }
    }
}
