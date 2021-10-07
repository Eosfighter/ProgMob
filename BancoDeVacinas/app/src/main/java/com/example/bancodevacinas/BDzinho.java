package com.example.bancodevacinas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BDzinho extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Banco";
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_VACINA = "vacina";
    private static final String DATABASE_VACINADOS = "vacinados";
    private static final String COLUM_ID = "id";

    //CAMPOS DA TABELA VACINA
    public static final int VACINA_ID = 1;
    public static final String NOME_VACINA = null;
    public static final String FABRICANTE = null;

    //CAMPOS DA TABELA VACINADOS
    public static final int NUM_VACINADOS = 1;
    public static final int VACINA_ID2 = 1;
    public static final String NOME_PESSOA = null;
    public static final String CPF = null;
    public static final int IDADE = 1;
    public static final int COLUM_NUM_VACINADO = 1;
    public static final int COLUM_VACINA_ID = 1;
    public static final String COLUM_NOME_PESSOA = "NomeDaPessoa";
    public static final String COLUM_CPF = "Cpf";
    public static final int COLUM_IDADE = 1;

    SQLiteDatabase bd;

    private static final String TABLE_CREATE1 =
            "create table vacina " +
            "(vacinaId integer primary key autoincrement," +
                    " nomeVacina text , " +
                    "fabricante text, )" +
                    ";";
    private static final String TABLE_CREATE2 =
            "create table vacinados " +
            "(numVacinado integer primary key autoincrement," +
            " vacinaId integer" +
             "FOREIGN KEY (vacinaId) REFERENCES  vacina(vacinaId)" +
            ", nomePessoa text," +" cpf text, " +"idade integer );";

   // private static final String nomeDoNegocio = "nome";
   // private static final String TABLE_CREATE =

    public BDzinho(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    public List<? extends Serializable> selectAllContato(){
        String[] coluns={DATABASE_NAME, String.valueOf(DATABASE_VERSION),DATABASE_VACINA, DATABASE_VACINADOS
                };
        Cursor cursor = getReadableDatabase().query(DATABASE_NAME,
                coluns,null,null,null,
                null,"upper(nome)",null);
        ArrayList<Vacina> listaVacina = new ArrayList<Vacina>();
        ArrayList<Vacinados> listaVacinados = new ArrayList<Vacinados>();
        while(cursor.moveToNext()){
            Vacina v = new Vacina();
            v.setVacinaId(cursor.getInt(0));
            v.setNomeVacina(cursor.getString(1));
            v.setFabricante(cursor.getString(2));
            listaVacina.add(v);
            Vacinados v2 = new Vacinados();
            v2.setNumVacinado(cursor.getInt(0));
            v2.setVacinaId(cursor.getInt(1));
            v2.setNomePessoa(cursor.getString(2));
            v2.setCpf(cursor.getString(3));
            v2.setIdade(cursor.getInt(4));
            listaVacinados.add(v2);
        }
        return listaVacina;

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
    bd.execSQL(TABLE_CREATE1);
    bd.execSQL(TABLE_CREATE2);
    this.bd = bd;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query = "DROP TABLE IF EXISTS "+DATABASE_NAME;
        bd.execSQL(query);
        onCreate(bd);
    }

    public long updateVacinados(Vacinados v2){
        long retornoBD;
        bd = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(String.valueOf(COLUM_NUM_VACINADO),v2.getNumVacinado());
        values.put(String.valueOf(COLUM_VACINA_ID),v2.getVacinaId());
        values.put(COLUM_NOME_PESSOA, v2.getNomePessoa());
        values.put(COLUM_CPF,v2.getCpf());
        values.put(v2.getNomePessoa(), COLUM_IDADE);
        String[] args = {String.valueOf(v2.getClass())};
        retornoBD = bd.update(DATABASE_NAME, values,"id=?", args);
        bd.close();
        return retornoBD;
    }

    public long deleteVacina(Vacina v){
        long retornoBD;
        bd = this.getWritableDatabase();
        String[] args = {String.valueOf(v.getClass())};
        retornoBD=bd.delete(DATABASE_NAME, +COLUM_ID"=?",args);
        return retornoBD;

    }


}
