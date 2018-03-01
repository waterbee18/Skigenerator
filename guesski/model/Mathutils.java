package guesski.model;

/**
 * Created by gabro on 2018-02-15.
 */
public class Mathutils {


            double value;
            Constant(double c){
                value = c;
            }

            public double getValue() {
                return value;
            }
        }

        public static double enegiepotentiel(double masse, double hauteur){
            return masse*9.81*hauteur;
        }
        public static double energieCinetique(double masse, double vitesse ){
            return 0.5*masse*Math.pow(2,vitesse);
        }

        public static double vitesseX(double vitesse, double angle){
            return Math.cos(angle)* vitesse;
        }

        public static double vitesseY(double vitesse, double angle){
            return Math.sin(angle)* vitesse;
        }

        public static double deltaY(double hauteurJump, double yfinale){
            return hauteurJump-yfinale;
        }

        public static double[] quad(double a, double b, double c){
            double x1= (-b + Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / (2 * a);
            double x2= (-b - Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / (2 * a);
            return new double[]{x1,x2};
        }
        public static double xFinal(double vitesseX, double temps){
            return vitesseX* temps;
        }



    }
