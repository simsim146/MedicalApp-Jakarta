package servlets;

import jakarta.inject.Inject;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Medecin;
import model.MedecinGeneraliste ;
import model.MedecinSpecialiste;
import service.MedecinService;
import java.io.IOException;

@WebServlet("/AjouterMedecin")
public class AjouterMedecin extends HttpServlet{
    @Inject
    private MedecinService medecinService;

    protected void doGet(HttpServletRequest request,HttpServletResponse response )
        throws IOException {

        request.setCharacterEncoding("UTF-8");

        String nom = request.getParameter("nom");
        String inpe = request.getParameter("inpe");
        String service = request.getParameter("service");
        String grade = request.getParameter("grade");
        String specialite = request.getParameter("specialite");

        boolean chirurgien = request.getParameter("chirurgien") != null;
        Medecin medecin;
        if(specialite == "Generaliste"){
            medecin = new MedecinGeneraliste(
            nom,
            inpe,
            service,
            grade);
        }
        else{
            medecin = new MedecinSpecialiste(
              nom,inpe,service,grade,specialite,chirurgien
            );//make sure your class constructor is set in the same order as this one
        }

        medecinService.ajouter(medecin);
        response.setContentType("texthtml;charset=UTF-8");
        response.getWriter().println("""
                <html>
                    <body>
                       <form>
                            <p>Medecin Ajoute avec Succes</p>
                            <form action="AfficherMedecins" method="get">
                            <button type="submit">Retourner a la liste</button>
                      </form>
                    </body>
                </html>
                """);
    }
}
