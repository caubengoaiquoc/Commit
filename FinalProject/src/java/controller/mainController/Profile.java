/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.mainController;

import controller.BaseController;
import dal.UserDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.UserModel;

/**
 *
 * @author Vova
 */
public class Profile extends BaseController {

  @Override
  protected void processGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    UserDao userDao = new UserDao();
    int id = Integer.parseInt(req.getParameter("id"));
    UserModel user = userDao.getUserInfo(id);
    req.setAttribute("user", user);
    int userImage = userDao.countUserImage(id);
    req.setAttribute("userImage", userImage);

    req.getRequestDispatcher("screens/profile.jsp").forward(req, resp);
  }

  @Override
  protected void processPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  }

}
