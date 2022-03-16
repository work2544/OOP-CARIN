package helloget;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/response")
public class HomeController {
    @PostMapping
    public String postBody(@RequestBody Person fullName) {
        return "Hello " + fullName.getFullName();
    }

}
