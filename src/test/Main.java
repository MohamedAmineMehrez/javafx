/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import Entities.Guide;
import Services.GuideService;


/**
 *
 * @author USER
 */
public class Main {
    public static void main(String[] args) {
        GuideService ps = new GuideService();
       // ps.ajouterGuide(new Guide("GuideDesktop", "hello from javaFx",24,"12/02/2220",125));
        System.out.println(ps.afficherGuide());
        ps.supprimerGuide(3);
        System.out.println("supprimer");
        
        System.out.println(ps.afficherGuide());
        ps.modifierGuideTitre(8, "Halima");
         System.out.println(ps.afficherGuide());
    }

    
}
