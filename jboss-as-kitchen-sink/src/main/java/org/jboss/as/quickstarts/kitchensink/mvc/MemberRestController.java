package org.jboss.as.quickstarts.kitchensink.mvc;

import java.util.List;

import org.jboss.as.quickstarts.kitchensink.model.Member;
import org.jboss.as.quickstarts.kitchensink.repo.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/rest/members")
public class MemberRestController
{
    @Autowired
    private MemberDao memberDao;

    @RequestMapping(method=RequestMethod.GET, produces="application/json")
    public List<Member> listAllMembers()
    {
        return memberDao.findAllOrderedByName();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET, produces="application/json")
    public Member lookupMemberById(@PathVariable("id") Long id)
    {
        return memberDao.findById(id);
    }
}
