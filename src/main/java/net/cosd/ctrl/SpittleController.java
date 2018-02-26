package net.cosd.ctrl;

import net.cosd.service.SpittleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/spittles")
public class SpittleController {
    private SpittleRepository spittleRepository;
    // 注入SpittleRepository
    @Autowired
    public SpittleController(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String spittles(Model model) {
        // Model实际就是一个Map (key-value对的组合)
        // 当调用addAttribute() 不指定key时, 那么key会根据值的对象类型推断确定.
        // 因为findSpittles() 返回List<Spittle>, so, key将会推断为spittleList.
        model.addAttribute(spittleRepository.findSpittles(Long.MAX_VALUE, 20));

        // 此处为显式声明Model的key
//      model.addAttributes("spittleList", spittleRepository.findSpittles(Long.MAX_VALUE, 20));
        return "spittles";
    }

    // 通过路径参数接受输入
    @RequestMapping(value = "/{spittleId}", method = RequestMethod.GET)
    public String spittles(@PathVariable("spittleId") long spittleId, Model model) {
        model.addAttribute(spittleRepository.findOne(spittleId));
        System.out.println(spittleRepository.findOne(spittleId).getMessage());
        return "spittles";
    }

}


