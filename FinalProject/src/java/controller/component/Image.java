/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.component;

import controller.BaseController;
import dal.ImageDao;
import dal.UserDao;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ImageDataModel;

/**
 *
 * @author Vova
 */
public class Image extends BaseController {

  @Override
  protected void processGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String sid = req.getParameter("id");
    ImageDao ud = new ImageDao();
    ImageDataModel imageData = new ImageDataModel();
    imageData = ud.getImageData(Integer.parseInt(sid));
    resp.setContentType(imageData.getContentType());
    ServletOutputStream out = resp.getOutputStream();
    out.write(imageData.getImageByte());
    out.flush();
    out.close();
  }

  @Override
  protected void processPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

}
