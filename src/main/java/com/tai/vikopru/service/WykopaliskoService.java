package com.tai.vikopru.service;

import com.tai.vikopru.crm.CrmWykopalisko;
import com.tai.vikopru.dao.WykopaliskoDAO;
import com.tai.vikopru.entity.User;
import com.tai.vikopru.entity.Wykopalisko;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


@Service
public class WykopaliskoService {
    @Autowired
    UserService userService;
    @Autowired
    WykopaliskoDAO wykopaliskoDAO;

    public void save(CrmWykopalisko crmWykopalisko) {
//        Get current logged in user
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        User user = userService.findByUserName(username);
        System.out.printf("Username: " + String.valueOf(auth.getPrincipal()));

        Wykopalisko wykopalisko = new Wykopalisko(
                crmWykopalisko.getTitle(),
                crmWykopalisko.getDescription(),
                crmWykopalisko.getImageSrc(),
                crmWykopalisko.getSourceUrl()
        );
        wykopalisko.setUser(user);
        wykopaliskoDAO.save(wykopalisko);
    }
}
