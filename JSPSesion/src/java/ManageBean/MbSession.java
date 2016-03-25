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
public class MbSession {

    private String usuario;
    private final HttpServletRequest httpServerRequest;
    private final FacesContext faceContext;
    private FacesMessage facesMessage;
    
    
    public MbSession() {
        faceContext=FacesContext.getCurrentInstance();
        httpServerRequest=(HttpServletRequest)faceContext.getExternalContext().getRequest() ;
        if(httpServerRequest.getSession().getAttribute("sessionUsuario") != null){
            usuario=httpServerRequest.getSession().getAttribute("sessionUsuario").toString();
        }
    }

    //*****************************************************************************************************//
    //*****************************************************************************************************//
    //                      otra pagina pagina                                                             //
    public String cerrarSession(){
        httpServerRequest.getSession().removeAttribute("sessionUsuario");
        facesMessage=new FacesMessage(FacesMessage.SEVERITY_INFO, "SESSION CERRADA CORRECTAMENTE",null);
        faceContext.addMessage(null, facesMessage);
        return "salida";
    
    }
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    
}
