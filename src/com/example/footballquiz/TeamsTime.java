package com.example.footballquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class TeamsTime extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teams);               
        String [] team = new String[1000];
        final int index = (int)(Math.random()*101);
        team[0] = "Manchester United";
        team[1] = "Manchester City";
        team[2] = "Chelsea";
        team[3] = "Arsenal";
        team[4] = "Liverpool";
        team[5] = "Everton";
        team[6] = "Aston Villa";
        team[7] = "Newcastle";
        team[8] = "Tottenham";
        team[9] = "Sunderland";
        team[10] = "Bolton";       
        team[11] = "West Bromwich Albion";
        team[12] = "Blackpool";
        team[13] = "Fulham";
        team[14] = "Stoke City";
        team[15] = "Blackburn";
        team[16] = "Birmingham";
        team[17] = "Wigan";
        team[18] = "Wolverhampton";
        team[19] = "West Ham United";
        team[20] = "Almería";
        team[21] = "Athletic Bilbao";
        team[22] = "Atlético Madrid";
        team[23] = "FC Barcelona";
        team[24] = "Deportivo La Coruña";
        team[25] = "Espanyol";
        team[26] = "Getafe";
        team[27] = "Hércules";
        team[28] = "Levante";
        team[29] = "Málaga";
        team[30] = "Mallorca";
        team[31] = "Osasuna";
        team[32] = "Racing Santander";
        team[33] = "Real Madrid";
        team[34] = "Real Sociedad";
        team[35] = "Sevilla";
        team[36] = "Sporting Gijon";
        team[37] = "Valencia";
        team[38] = "Villareal";
        team[39] = "Zaragoza";
        team[40] = "Bari";
        team[41] = "Brescia";
        team[42] = "Bologna";
        team[43] = "Cagliari";
        team[44] = "Catania";
        team[45] = "Chievo";
        team[46] = "Cesena";
        team[47] = "Fiorentina";
        team[48] = "Genoa";
        team[49] = "Inter";
        team[50] = "Juventus";
        team[51] = "Lazio";
        team[52] = "Lecce";
        team[53] = "Milan";
        team[54] = "Napoli";
        team[55] = "Palermo";
        team[56] = "Parma";
        team[57] = "Roma";
        team[58] = "Sampdoria";
        team[59] = "Udinese";
        team[60] = "Orlando Pirates";
        team[61] = "Panathinaikos";
        team[62] = "Olympiacos";
        team[63] = "AEK Athen";
        team[64] = "FC Porto";
        team[65] = "Sporting Lisboa";
        team[66] = "Braga";
        team[67] = "Monaco";
        team[68] = "CFR Cluj";
        team[69] = "CSKA Moscow";
        team[70] = "Celtic";
        team[71] = "Club Brügge";
        team[72] = "Bayern München";
        team[73] = "Bordeaux";
        team[74] = "Lyon";
        team[75] = "LOSC Lille";
        team[76] = "Bayer Leverkusen";
        team[77] = "Paris Saint Germain";
        team[78] = "Fenerbache";
        team[79] = "Ajax";
        team[80] = "PSV Eindhoven";
        team[81] = "Galatasaray";
        team[82] = "FC Groningen";
        team[83] = "Schalke 04";
        team[84] = "Werder Bremen";
        team[85] = "Benfica";
        team[86] = "Boca Juniors";
        team[87] = "Santos";
        team[88] = "Corinthinias";
        team[89] = "Marseille";
        team[90] = "Stade Rennais";
        team[91] = "FC Copenhagen";
        team[92] = "Bröndby";
        team[93] = "Rubin Kazan";
        team[94] = "Spartak Moscow";
        team[95] = "FC Zenit";
        team[96] = "Wolfsburg";
        team[97] = "River Plate";
        team[98] = "Glasgow Rangers";
        team[99] = "LA Galaxy";
        team[100] = "New York Redbulls";
        team[101] = "Wisla Krakow";               
        TextView textView = (TextView) findViewById(R.id.TextView01);
        textView.setText(team[index]);
        
        int [] team1 = new int[1000];
        int index1 = (int)(Math.random()*101);
        int index2 = (int)(Math.random()*101);
        int index3 = (int)(Math.random()*101);        
        team1[0] = R.drawable.manutd;
        team1[1] = R.drawable.man_city;
        team1[2] = R.drawable.chelsea;
        team1[3] = R.drawable.arsenal;
        team1[4] = R.drawable.liverpool;
        team1[5] = R.drawable.everton;
        team1[6] = R.drawable.aston_villa;
        team1[7] = R.drawable.newcastle_united;
        team1[8] = R.drawable.tottenham;
        team1[9] = R.drawable.sunderland;
        team1[10] = R.drawable.bolton;
        team1[11] = R.drawable.wba;
        team1[12] = R.drawable.blackpool;
        team1[13] = R.drawable.fulham;
        team1[14] = R.drawable.stoke_city;
        team1[15] = R.drawable.blackburn;
        team1[16] = R.drawable.birmingham;
        team1[17] = R.drawable.wigan;
        team1[18] = R.drawable.wolves;
        team1[19] = R.drawable.west_ham;
        team1[20] = R.drawable.almeria;
        team1[21] = R.drawable.athletic_bilbao;
        team1[22] = R.drawable.atletico_madrid;
        team1[23] = R.drawable.barcelona;
        team1[24] = R.drawable.deportivo_la_coruna;
        team1[25] = R.drawable.espanyol;
        team1[26] = R.drawable.getafe;
        team1[27] = R.drawable.hercules;
        team1[28] = R.drawable.levante;
        team1[29] = R.drawable.malaga;
        team1[30] = R.drawable.mallorca;
        team1[31] = R.drawable.osasuna;
        team1[32] = R.drawable.racing_santander;
        team1[33] = R.drawable.real_madrid;
        team1[34] = R.drawable.real_sociedad;
        team1[35] = R.drawable.sevilla;
        team1[36] = R.drawable.sporting_gijon;
        team1[37] = R.drawable.valencia;
        team1[38] = R.drawable.villareal;
        team1[39] = R.drawable.zaragoza;
        team1[40] = R.drawable.bari;
        team1[41] = R.drawable.brescia;
        team1[42] = R.drawable.bologna;
        team1[43] = R.drawable.cagliaro;
        team1[44] = R.drawable.catania;
        team1[45] = R.drawable.chievo;
        team1[46] = R.drawable.cesena;
        team1[47] = R.drawable.fiorentina;
        team1[48] = R.drawable.genoa;
        team1[49] = R.drawable.inter;
        team1[50] = R.drawable.juventus;
        team1[51] = R.drawable.lazio;
        team1[52] = R.drawable.lecce;
        team1[53] = R.drawable.milan;
        team1[54] = R.drawable.napoli;
        team1[55] = R.drawable.palermo;
        team1[56] = R.drawable.parma;
        team1[57] = R.drawable.roma;
        team1[58] = R.drawable.sampdoria;
        team1[59] = R.drawable.udinese;
        team1[60] = R.drawable.orlando_pirates;
        team1[61] = R.drawable.panathinaikos;
        team1[62] = R.drawable.olympiakos;
        team1[63] = R.drawable.aek_athen;
        team1[64] = R.drawable.fc_porto;
        team1[65] = R.drawable.sporting_lissabon;
        team1[66] = R.drawable.sc_braga;
        team1[67] = R.drawable.monaco;
        team1[68] = R.drawable.cfr_cluj;
        team1[69] = R.drawable.cska_moskva;
        team1[70] = R.drawable.celtic;
        team1[71] = R.drawable.club_brugge;
        team1[72] = R.drawable.bayern_munchen;
        team1[73] = R.drawable.bordeaux;
        team1[74] = R.drawable.lyon;
        team1[75] = R.drawable.lille;
        team1[76] = R.drawable.bayer_leverkusen;
        team1[77] = R.drawable.paris_saint_germain;
        team1[78] = R.drawable.fenerbahce;
        team1[79] = R.drawable.ajax;
        team1[80] = R.drawable.psv_eindhoven;
        team1[81] = R.drawable.galatasaray;
        team1[82] = R.drawable.fc_groningen;
        team1[83] = R.drawable.schalke_04;
        team1[84] = R.drawable.werder_bremen;
        team1[85] = R.drawable.benfica;
        team1[86] = R.drawable.boca_juniors;
        team1[87] = R.drawable.santos;
        team1[88] = R.drawable.corinthians;
        team1[89] = R.drawable.marseille;
        team1[90] = R.drawable.stade_rennais;
        team1[91] = R.drawable.fc_kobenhavn;
        team1[92] = R.drawable.fc_brondby;
        team1[93] = R.drawable.rubin_kazan;
        team1[94] = R.drawable.spartk_moscow;
        team1[95] = R.drawable.fc_zenit;
        team1[96] = R.drawable.wolfsburg;
        team1[97] = R.drawable.river_plate;
        team1[98] = R.drawable.glasgow_rangers;
        team1[99] = R.drawable.la_galaxy;
        team1[100] = R.drawable.new_york_red_bulls;
        team1[101] = R.drawable.wisla_krakow;
        
        if(index == index1){
        	index1 = (int)(Math.random()*101);
        }
        if(index == index2){
        	index2 = (int)(Math.random()*101);
        }
        if(index == index3){
        	index3 = (int)(Math.random()*101);
        }
        if(index1 == index2){
        	index2 = (int)(Math.random()*101);
        }
        if(index1 == index3){
        	index3 = (int)(Math.random()*101);
        }
        if(index2 == index3){
        	index3 = (int)(Math.random()*101);
        }
        
        ImageView imageView = (ImageView) findViewById(R.id.ImageButton01);
        imageView.setImageResource(team1[index]);
        ImageView imageView0 = (ImageView) findViewById(R.id.ImageButton02);
        imageView0.setImageResource(team1[index1]);
        ImageView imageView1 = (ImageView) findViewById(R.id.ImageButton03);
        imageView1.setImageResource(team1[index2]);
        ImageView imageView2 = (ImageView) findViewById(R.id.ImageButton04);
        imageView2.setImageResource(team1[index3]);
        
        final ImageButton imageButton = (ImageButton) findViewById(R.id.ImageButton01);
		imageButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(TeamsTime.this, Level1.class));
			}
        });
        final ImageButton imageButton0 = (ImageButton) findViewById(R.id.ImageButton02);
		imageButton0.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(TeamsTime.this, Teams.class));
			}
        });
        final ImageButton imageButton1 = (ImageButton) findViewById(R.id.ImageButton03);
		imageButton1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(TeamsTime.this, Teams.class));
			}
        });
        final ImageButton imageButton2 = (ImageButton) findViewById(R.id.ImageButton04);
		imageButton2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(TeamsTime.this, Teams.class));
			}
        });
    }
}
        
        
        
        
    

    
