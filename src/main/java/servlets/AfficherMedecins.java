package servlets;

import jakarta.inject.Inject;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Medecin;
import model.MedecinSpecialiste;
import service.MedecinService;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@WebServlet("/AfficherMedecins")
public class AfficherMedecins extends HttpServlet{
    @Inject
    private MedecinService medecinService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException{

        List<Medecin> medecins = medecinService.lister();
        String lignes = "";
        if (medecins!=null){



            for (Medecin medecin : medecins){
                if(medecin instanceof MedecinSpecialiste){
                    String chirurgian = ((MedecinSpecialiste)
                    medecin).isChirurgien() ? "oui" : "non";
                    lignes += """
                                <tr>
                                    <td>%s</td>
                                    <td>%s</td>
                                    <td>%s</td>
                                    <td>%s</td>
                                    <td>%s</td>
                                    <td>%s</td>
                                </tr>
                            """.formatted(
                            medecin.getNom(),
                            medecin.getINPE(),
                            medecin.getService(),
                            medecin.getGrade(),
                            ((MedecinSpecialiste)medecin).getSpecialite(),
                            chirurgian
                    );
                }else{
                    lignes += """
                                <tr>
                                    <td>%s</td>
                                    <td>%s</td>
                                    <td>%s</td>
                                    <td>%s</td>
                                    <td>%s</td>
                                    <td>%s</td>
                                </tr>
                            """.formatted(
                                    medecin.getNom(),
                                    medecin.getINPE(),
                                    medecin.getService(),
                                    medecin.getGrade(),
                            "Generaliste",
                            "non"
                    );
                }
            }

            response.setContentType("text/html;charset=UTF-8");
        }
        response.getWriter().println("""
                <html>
                    <body>
                        <h2>Liste des medecins</h2>
                        
                        <table border ="1">
                            <tr>
                                <th>Nom</th>
                                <th>INPE</th>
                                <th>Service</th>
                                <th>Grade</th>
                                <th>Specialite</th>
                                <th>Est chirurgien?</th>
                            </tr>
                            %s
                        </table>
                        <form action="ajouter_medecin.html" method="get">
                            <button type = "submit">Ajouter un medecin</button>
                        </form>
                    </body>
                </html>                    
                """.formatted(lignes));

    }

}
