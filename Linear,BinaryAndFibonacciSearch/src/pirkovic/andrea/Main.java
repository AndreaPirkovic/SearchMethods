package pirkovic.andrea;

import java.util.Scanner;

public class Main {
	// linearna pretraga pretrazuje elemente niza jedan po jedan, dok ne naidje na podudaranje, veoma je spora
	// metod za linearnu pretragu:
public static int linearnaPretraga(int[] niz, int trazenaVrednost){    
			        for(int i=0;i<niz.length;i++){    
			            if(niz[i] == trazenaVrednost){    
			                return i;
			                 
			            }    
			        }    
			        return -1;
			    }   

/*Binarna pretraga funkcionise na sledeci nacin:
Postavite niski indeks na prvi element niza, a visoki indeks na poslednji element.
Postavite srednji indeks na prosek niskog i visokog indeksa.
Ako je element u srednjem indeksu ciljni element, vratite srednji indeks.
U suprotnom, na osnovu vrednosti ključa koji treba da se pronađe i vrednosti srednjeg elementa, odlučite za sledeći prostor za pretragu.
Ako je cilj manji od elementa u srednjem indeksu, postavite visoki indeks na srednji indeks – 1.
Ako je cilj veći od elementa u srednjem indeksu, postavite niski indeks na srednji indeks + 1.
Izvršite korak 2 više puta dok se ciljni element ne pronađe ili dok se ne iscrpi prostor za pretragu.
*NIZ MORA BITI SORTIRAN ZA BINARNU PRETRAGU U RASTUCI NIZ.
*/

//metod za binarnu pretragu:
public static void binarnaPretraga(int niz[], int prvi, int poslednji, int trazenaVrednost){  
	   int mid = (prvi + poslednji)/2;  
	   while( prvi <= poslednji ){  
	      if ( niz[mid] < trazenaVrednost ){  
	       prvi = mid + 1;     
	      }else if ( niz[mid] == trazenaVrednost ){  
	        System.out.println("Element je pronadjen na indeksu: " + mid);  
	        break;  
	      }else{  
	         poslednji = mid - 1;  
	      }  
	      mid = (prvi + poslednji)/2;  
	   }  
	   if ( prvi > poslednji ){  
	      System.out.println("Element nije pronadjen!");  
	   }  
	 }  
/*Fibonačijeva pretraga je tehnika zasnovana na poređenju koja koristi Fibonačijeve brojeve za pretragu elementa u sortiranom nizu.
 * Fibonačijeva pretraga deli dati niz na nejednake delove.
Fibonačijeva pretraga ispituje relativno bliže elemente trazenom elementu u postupnim koracima.
 Niz mora biti sortiran za ovu vrstu pretrage */
//metod za fibonaci pretragu
static int fibonaci(int niz[], int n, int trazenaVrednost) {
    int offset = -1; // Označava eliminisani opseg sa prednje strane
    int Fm2 = 0;//Pronađite najmanji Fibonačijev broj veći ili jednak n. Neka ovaj broj bude Fm [m’th Fibonačijev broj]. Neka dva Fibonačijeva broja koja prethode budu Fm1 [(m-1)’th Fibonačijev broj] i Fm2 [(m-2)’th Fibonačijev broj].
    int Fm1 = 1;
    int Fm = Fm2 + Fm1;
    while (Fm < n) {// fibM će uskladištiti najmanji Fibonačijev broj veći ili jednak n 
       Fm2 = Fm1;
       Fm1 = Fm;
       Fm = Fm2 + Fm1;
    }
    while (Fm > 1) {
       int i = Math.min(offset + Fm2, n - 1);
       if (niz[i] < trazenaVrednost) {/* Ako je trazena vrednost veća od vrednosti na
    	   indeksu Fm2, iseći niz podniza od ofseta do i */
          Fm = Fm1;
          Fm1 = Fm2;
          Fm2 = Fm - Fm1;
          offset = i; // ofset se podesava na indeks i
      } else if (niz[i] > trazenaVrednost) {/* Ako je trazne vrednost manja od vrednosti u indeksu
    	  Fm2, iseći podniz posle i+1 */
          Fm = Fm2;
          Fm1 = Fm1 - Fm2;
          Fm2 = Fm - Fm1;
      } else // ako je pronadjen element vrati njegov indeks
        return i;
    }
    if (Fm1 == 1 && niz[offset + 1] == trazenaVrednost)// poredjenje poslednjeg elementa niza sa trazenim elementom
       return offset + 1;
    return -1;
 }
	public static void main(String[] args) {
		 
		 int[] Niz = {10,20,30,40,50}; // kreiranje niza za pretragu
		 
		 System.out.println("Ispitivani niz:");
		 for (int i = 0; i < Niz.length; i++) {
			 System.out.println(Niz[i]);}// stampa niza
		 int poslednji=Niz.length-1;  
		 Scanner sc= new Scanner(System.in);
		 System.out.println("Unesite vrednost za pretragu:");// unosenje vrednosti za pretragu preko konzole
			     int vrednost = sc.nextInt();  
			     int rezultatPretrage=linearnaPretraga(Niz, vrednost);// pozivanje metode za linearnu pretragu   
			     System.out.println("Rezultat linearne pretrage:");
			     if (rezultatPretrage == -1)
			        System.out.println("Vrednost nije pronadjena u nizu pomocu linearne pretrage");
			     else 
			        System.out.println(vrednost + " se nalazi u nizu na indeksu: "+ rezultatPretrage ); 
			      System.out.println("Rezultat binarne pretrage:");
			        binarnaPretraga(Niz,0,poslednji,vrednost);  // pozivanje metode za binarnu pretragu   
			        int rezultatFibonacija=fibonaci(Niz,Niz.length, vrednost);// pozivanje metode za fibonaci pretragu
				     System.out.println("Rezultat fibonaci pretrage:");
				     if (rezultatFibonacija == -1)
				        System.out.println("Vrednost nije pronadjena u nizu pomocu Fibonaci pretrage");
				     else 
				        System.out.println(vrednost + " se nalazi u nizu na indeksu: "+ rezultatFibonacija );  
	}    

	}


