package com.proyecto.proyecto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager;
    public static ArrayList<Categoria> listacategorias = new ArrayList<>();
    public static ArrayList<Evento> listaeventos = new ArrayList<>();

    BottomNavigationView menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Inicio | Categorias");
        setContentView(R.layout.activity_main);
        menu = findViewById(R.id.menunav);
        fragmentManager = getSupportFragmentManager();

        cargarCategorias();

        HomeFragment homeFragment1 = new HomeFragment();
        fragmentManager.beginTransaction().add( R.id.contenido, homeFragment1, HomeFragment.class.getName() ).commit();

        menu.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Log.i("a", item.getTitle().toString());
                if ("Inicio".equals(item.getTitle())) {
                    HomeFragment homeFragment = new HomeFragment( );
                    fragmentManager.beginTransaction().add( R.id.contenido, homeFragment, HomeFragment.class.getName() ).addToBackStack(null).commit();
                    setTitle("Inicio | Categorias");
                    return true;
                }else if ("Buscar".equals(item.getTitle())) {
                    BuscarFragment buscarFragment = new BuscarFragment( );
                    fragmentManager.beginTransaction().add( R.id.contenido, buscarFragment, HomeFragment.class.getName() ).addToBackStack(null).commit();
                    setTitle("Buscar");
                    return true;
                }else if ("Perfil".equals(item.getTitle())) {
                    PerfilFragment perfilFragment = new PerfilFragment( );
                    fragmentManager.beginTransaction().add( R.id.contenido, perfilFragment, HomeFragment.class.getName() ).addToBackStack(null).commit();
                    setTitle("Perfil");
                    return true;
                }else{
                    return false;
                }
            }
        });
    }

    private void cargarCategorias() {
        Categoria conferencia = new Categoria( "Conferencia",R.drawable.fabiii12 );
        Categoria taller = new Categoria( "Taller", R.drawable.sghsjjajd );
        Categoria concierto = new Categoria( "Concierto", R.drawable.ssfvconci);
        Categoria curso = new Categoria( "Curso", R.drawable.cusros23);

        this.listacategorias.add( conferencia );
        this.listacategorias.add( taller );
        this.listacategorias.add( concierto );
        this.listacategorias.add( curso );

        this.listaeventos.add( new Evento("GBTA Conferencia", "15/12/2021", "Puebla centro, zaragoza 115", "La Conferencia GBTA tiene tem??ticas relacionadas a la Industria de viajes corporativos, reuniones e incentivos con speakers nacionales e internacionales, y l??deres de la industria que comparten su visi??n en un foro colaborativo que promueve la profesionalizaci??n de sus asistentes", conferencia) );
        this.listaeventos.add( new Evento("Gran Slam", "15/12/2021", "Puebla centro, zaragoza 115", "Los Grand Slam son los 4 torneos m??s importantes del circuito de tenis y se disputan cada a??o. En categor??a masculina los partidos se juegan al mejor de 5 sets (a diferencia del resto de campeonatos del calendario que se disputan al mejor de 3)", conferencia) );
        this.listaeventos.add( new Evento("POP Life! The Pop Culture Festival", "15/12/2021", "Puebla centro, zaragoza 115", "Este festival re??ne a trav??s de la m??sica, expositores, conferencias, actividades, fotograf??a, cine y m??s, lo mejor de las d??cadas de los 80??s y 90??s. Fusionamos toda una generaci??n que nos identific??", conferencia) );
        this.listaeventos.add( new Evento("Feria Nacional de Bebidas T??picas 2022", "15/12/2021", "Puebla centro, zaragoza 115", "Este festival se llevar?? a cabo del 1 al 3 de diciembre en Expo Reforma. Mucho se habla sobre la gastronom??a alrededor del mundos", conferencia) );
        this.listaeventos.add( new Evento("FORO FINTECH M??XICO", "15/12/2021", "Puebla centro, zaragoza 115", "Fintech es un conjunci??n abreviada de los t??rminos ???finanzas??? y ???tecnolog??a??? en ingl??s y se refiere a cualquier negocio que utilice la tecnolog??a para mejorar o automatizar los servicios y procesos financieros", conferencia) );
        this.listaeventos.add( new Evento("Feria Internacional de Tecnolog??a y Manufactura - FITMA", "15/12/2021", "Puebla centro, zaragoza 115", "La misi??n de FITMA es la de desarrollar una exposici??n especializada para el sector metalmec??nico, de car??cter internacional, que conecte la cadena de suministro de la manufactura global con el r??pido crecimiento del mercado industrial de Am??rica Latina", conferencia) );
        this.listaeventos.add( new Evento("MUA", "15/12/2021", "Puebla centro, zaragoza 115", "MUA informa a la comunidad sobre su derecho a recibir servicios en su idioma en cualquier agencia p??blica de la Ciudad, como lo indica la Ordenanza de Acceso Ling????stico de San Francisco, y provee asistencia directa a miembras que necesiten hacer una queja por falta de servicios en su idioma o mala calidad de los mismos", conferencia) );
        this.listaeventos.add( new Evento("Preguntas Frecuentes Expositores", "15/12/2021", "Puebla centro, zaragoza 115", "El Congreso de la UICN, que se celebra cada cuatro a??os, es el evento de conservaci??n m??s grande del mundo. Re??ne a l??deres de gobiernos", conferencia) );
        this.listaeventos.add( new Evento("Hacia la construcci??n de ciudades del aprendizaje sostenibles", "15/12/2021", "Ciudad de Mexico", "Conferencia Internacional sobre Ciudades de Aprendizaje (ICLC), organizada por la UNESCO y el Gobierno de la Ciudad de M??xico", conferencia) );
        this.listaeventos.add( new Evento("TI general Ferias 2022 - 2023", "15/12/2021", "Puebla centro, zaragoza 115", "Conferencia y Exposici??n Internacional de Tecnolog??as de la Educaci??n y el Aprendizaje y Tecnolog??as de la Informaci??n y la Comunicaci??n", conferencia) );


        this.listaeventos.add( new Evento("Taller de danza ", "10/01/2022", "Centro de artes Hidalgo numero 22", "taller de danza es una forma de ensenar la danza, de modo que lo m??s importante es utilizar el movimiento como ???material??? de creaci??n o crear nuevos materiales para los fines de la propia danza", taller) );
        this.listaeventos.add( new Evento("Taller de musica", "10/01/2022", "Centro de artes Hidalgo numero 22", "Es un curso te??rico-pr??ctico que tiene como prop??sito que el estudiante conozca y experimente los elementos de la m??sica en las artes esc??nicas y el vocabulario musical b??sico para su aplicaci??n en la comprensi??n y ejecuci??n musical, a trav??s de la interpretaci??n musical b??sica en canto", taller) );
        this.listaeventos.add( new Evento("Taller de Matem??ticas", "10/01/2022", "Centro de artes Hidalgo numero 22", "Taller de Matem??ticas ha de proporcionar al alumnado la oportunidad de incorporar las matem??ticas al bagaje de saberes que le son ??tiles en la vida diaria, fortaleciendo las relaciones que hay entre las matem??ticas y el mundo que le rodea; donde desarrolle su gusto por la actividad matem??tica", taller) );
        this.listaeventos.add( new Evento("Taller creativo", "10/01/2022", "Centro de artes Hidalgo numero 22", "Los talleres creativos pueden proveer una visi??n perspicaz invaluable de perspectivas ajenas respecto a temas particulares", taller) );
        this.listaeventos.add( new Evento("Taller de artes", "10/01/2022", "Centro de artes Hidalgo numero 22", "Los talleres de educaci??n art??stica contribuyen al desarrollo integral de los ni??os y adolescentes porque les ayudan a expresar su creatividad y sensibilidad", taller) );
        this.listaeventos.add( new Evento("Taller de construccion", "10/01/2022", "Centro de artes Hidalgo numero 22", "Se ubica antes de las materias de Administraci??n de la Construcci??n ya que le permitir?? comprender el proceso constructivo l??gico para posteriormente llevar a cabo la planeaci??n, organizaci??n y control de obra.", taller) );
        this.listaeventos.add( new Evento("Taller de cocina", "10/01/2022", "Centro de artes Hidalgo numero 22", "Esto los ayuda a fortalecer su identidad, seguridad y esp??ritu ingenioso. Para muchos peque??os aprendices de cocinero, preparar platos que gusten los ayuda a mantener la motivaci??n, enfoque y a seguir intent??ndolo hasta alcanzar la perfecci??n", taller) );
        this.listaeventos.add( new Evento("Taller de manualidades", "10/01/2022", "Centro de artes Hidalgo numero 22", "Tener la oportunidad de crear es una de las experiencias m??s enriquecedoras que puede tener un ni??o, ya sea haciendo uso de materiales reciclados o de herramientas de ??ltima tecnolog??a como impresoras 3D, el proceso creativo desarrolla la imaginaci??n, fomenta la creatividad, la curiosidad y  mejora la motricidad", taller) );
        this.listaeventos.add( new Evento("Taller informatica", "10/01/2022", "Centro de artes Hidalgo numero 22", "El mundo cambia y las actividades extraescolares tambi??n, es fundamental que nuestros hijos cuenten con conocimientos que les permitan salir adelante en el mundo actual, y la inform??tica es uno de ellos.", taller) );
        this.listaeventos.add( new Evento("Taller de artes marciales", "10/01/2022", "Centro de artes Hidalgo numero 22", "Este tipo de actividades tiene todos los beneficios de los deportes en general, pero aparte da la posibilidad de acercarse un poco a otras culturas. Las artes marciales son un ejemplo claro de disciplina y compromiso", taller) );


                this.listaeventos.add( new Evento("PXNDX", "15/12/2021", "CDMX", "Compra boletos para PXNDX en Ticketmaster MX", concierto) );
        this.listaeventos.add( new Evento("Linkin Park", "16/12/2021", "CDMX", "El concierto homenaje a Chester Bennington, Compra boletos en Ticketmaster MX", concierto) );
        this.listaeventos.add( new Evento("Imagine Dragons", "17/12/2021", "CDMX", "Compra boletos para Imagine Dragons en Ticketmaster MX. Imagine Dragons", concierto) );
        this.listaeventos.add( new Evento("Twenty One Pilots", "18/12/2021", "CDMX", "Compra boletos para PXNDX en Ticketmaster MX", concierto) );
        this.listaeventos.add( new Evento("Green Day", "19/12/2021", "CDMX", "Compra boletos para Green Day en Ticketmaster MX", concierto) );
        this.listaeventos.add( new Evento("Hoobastank", "20/12/2021", "CDMX", "Compra boletos para Hoobastank en Ticketmaster MX", concierto) );
        this.listaeventos.add( new Evento("Avril Lavigne", "21/12/2021", "CDMX", "Compra boletos para Avril Lavigne en Ticketmaster MX", concierto) );
        this.listaeventos.add( new Evento("Elefante", "22/12/2021", "CDMX", "Compra boletos para Elefante en Ticketmaster MX", concierto) );
        this.listaeventos.add( new Evento("Starset", "23/12/2021", "CDMX", "Compra boletos para Starset en Ticketmaster MX", concierto) );
        this.listaeventos.add( new Evento("State of Mind", "25/12/2021", "CDMX", "Compra boletos para State of Mind en Ticketmaster MX\n", concierto) );


        this.listaeventos.add( new Evento("Curso de programacion", "15/01/2022", "Xicotepec de Juarez, Centro numero34", "Este curso te ense??ar?? a pensar como un programador, creando algoritmos y aplicando soluciones en lenguajes de programaci??n reales", curso) );
        this.listaeventos.add( new Evento("Curso Ingl??s", "15/01/2022", "Xicotepec de Juarez, Centro numero34", "Aprender ingl??s en tiempo r??cord es posible con Berlitz. Nuestras clases son 100% personalizables para que las adaptes a tu vida y les saques el mejor", curso) );
        this.listaeventos.add( new Evento("Curso de contabilidad", "15/01/2022", "Xicotepec de Juarez, Centro numero34", "Dirigida a aquellos que cuentan con habilidades de cara??cter matema??tico. ??Inf??rmate! Formamos profesionales de la contaduri??a que proporcionan informacio??n financiera.\n", curso) );
        this.listaeventos.add( new Evento("Cursos de Administraci??n", "15/01/2022", "Xicotepec de Juarez, Centro numero34", "Tiene la finalidad de conocer, comprender y aplicar los procesos de planeaci??n, organizaci??n, direcci??n y control de los recursos de una empresa; mediante el estudio del liderazgo, la gesti??n administrativa, log??stica y financiera, la cual es necesaria para dirigir un negocio o empresa", curso) );
        this.listaeventos.add( new Evento("Cursos de M??rketing", "15/01/2022", "Xicotepec de Juarez, Centro numero34", "Convi??rtete en un experto de marketing digital a un nivel b??sico con nuestro curso gratuito acreditado por la agencia Interactive ", curso) );
        this.listaeventos.add( new Evento("Cursos de Liderazgo", "15/01/2022", "Xicotepec de Juarez, Centro numero34", "El curso de liderazgo tiene el prop??sito que el aprendiz conozca y comprenda la manera como se puede influenciar a las personas", curso) );
        this.listaeventos.add( new Evento("Cursos en formaci??n de gesti??n", "15/01/2022", "Xicotepec de Juarez, Centro numero34", "Este programa de formaci??n est?? creado para favorecer que el alumno que lo siga pueda tener una visi??n clara de la gesti??n por procesos", curso) );
        this.listaeventos.add( new Evento("Cursos en Gesti??n de riesgos", "15/01/2022", "Xicotepec de Juarez, Centro numero34", "Especial??zate en gesti??n de riesgos financieros y aprende a reaccionar ante los problemas. F??rmate en 8 semanas con un formato totalmente online", curso) );
        this.listaeventos.add( new Evento("Curso Espa??ol", "15/01/2022", "Xicotepec de Juarez, Centro numero34", "Cursos de espa??ol pueden ser la opci??n ideal para las personas que deseen aprender una segunda lengua que podr??an ser de utilidad en el d??a a d??a de la vida, as?? como en los negocios. Espa??ol es un lenguaje vers??til, que se habla en todo el mundo. ??Qu?? es un curso de idiomas en espa??ol? Un curso de espa??ol ense??a a los estudiantes a hablar el idioma, adem??s de escribir y leer", curso) );
        this.listaeventos.add( new Evento("Curso Contabilidad", "15/01/2022", "Xicotepec de Juarez, Centro numero34", "Los cursos en contabilidad son una excelente manera de diversificar educaci??n y experiencia a la vez que los estudiantes mejoran su capacidad profesional, ya sean contables en busca de refrescar conocimientos o est??n interesados en un cambio de carrera. Hay cursos en Contabilidad disponibles en varios pa??ses y cada uno es espec??fico para un ??rea en particular", curso) );
        this.listaeventos.add( new Evento("Curso Negocios", "15/01/2022", "Xicotepec de Juarez, Centro numero34", "Los cursos en Negocios pueden complementar tu experiencia profesional y acad??mica, ya lleves en el mundo empresarial mucho tiempo o est??s buscando un cambio profesional. Hay muchas instituciones educativas en todo el mundo que imparten educaci??n empresarial de calidad por parte de un profesorado profesional", curso) );

    }

    public static ArrayList<Categoria> getCategorias(){
        return listacategorias;
    }
    public static ArrayList<Evento> getEventos(){
        return listaeventos;
    }
    public static Context getContext(){
        return getContext();
    }
}