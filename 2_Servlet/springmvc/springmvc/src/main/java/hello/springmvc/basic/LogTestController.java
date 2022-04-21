package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController//그냥 Controller와의 차이는 Controller는 view를 찾고,RestController는 바로 html body에 작성
public class LogTestController {
    //private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logTest(){
        String name = "Spring";

        System.out.println("name = " + name);

        log.trace("trace log ={}", name);
        log.debug("debug log ={}", name);
        log.info("info log={}", name);
        log.warn("warn log ={}", name);
        log.error("error log ={}", name);

        return "ok";
    }

}
