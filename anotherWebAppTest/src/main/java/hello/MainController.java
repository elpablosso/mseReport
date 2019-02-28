package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path="/game")
public class MainController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PotionRepository potionRepository;

    @GetMapping(path="add")
    public  @ResponseBody String addNewUser (@RequestParam String name, @RequestParam String email){
        User n = new User();
        n.setName(name);
        n.setEmail(email);
        userRepository.save(n);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll(); }

     @GetMapping(path="/find")
    public @ResponseBody String showFirstOne(@RequestParam String email){
         List<User> usersFound  = userRepository.findByEmail(email);
         return usersFound.get(0).toString();
     }
}
