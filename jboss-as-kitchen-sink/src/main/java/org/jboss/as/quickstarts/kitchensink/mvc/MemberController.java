package org.jboss.as.quickstarts.kitchensink.mvc;

 import org.jboss.as.quickstarts.kitchensink.model.Member;
import org.jboss.as.quickstarts.kitchensink.repo.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/")
public class MemberController
{
    @Autowired
    private MemberDao memberDao;

    @RequestMapping(method=RequestMethod.GET)
    public String displaySortedMembers(Model model)
    {
        model.addAttribute("newMember", new Member());
        model.addAttribute("members", memberDao.getMembersOrderedByName());

        return "index";
    }

    @RequestMapping(method=RequestMethod.POST)
    public String registerNewMember(Member newMember)
    {
        memberDao.register(newMember);
        return "index";
    }

    /*    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public String viewMember(@PathVariable("id") Long id, Model model)
    {
        model.addAttribute("member", memberDao.findById(id));
        return "viewMember";
    }*/
}
