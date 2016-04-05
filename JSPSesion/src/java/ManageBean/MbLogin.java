/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageBean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author salador
 */
@ManagedBean
@RequestScoped
public class MbLogin {

    
    
    private String usuario;
    private String contrasena;
    private final HttpServletRequest httpServerRequest;
    private final FacesContext faceContext;
    private FacesMessage facesMessage;
    
    /**
     * Creates a new instance of MbLogin
     */
    public MbLogin() {
        faceContext=FacesContext.getCurrentInstance();
        httpServerRequest=(HttpServletRequest)faceContext.getExternalContext().getRequest() ;
    }
    
    public String login(){
    
        if(usuario.equals("lol") && contrasena.equals("1234")){
            httpServerRequest.getSession().setAttribute("sessionUsuario", usuario);
            facesMessage=new FacesMessage(FacesMessage.SEVERITY_INFO, "Acceso Correcto",null);
            faceContext.addMessage(null, facesMessage);
            return "acceso";
        }else{
                        
            facesMessage=new FacesMessage(FacesMessage.SEVERITY_ERROR, "datos incorrecto",null);
            faceContext.addMessage(null, facesMessage);
            return "index";
        
        }
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
}
