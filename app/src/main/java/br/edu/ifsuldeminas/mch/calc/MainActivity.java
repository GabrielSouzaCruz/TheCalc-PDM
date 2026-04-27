package br.edu.ifsuldeminas.mch.calc;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import de.congrace.exp4j.Calculable;
import de.congrace.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "ifsuldeminas.mch.calc";
    private Button buttonZero, buttonUm, buttonDois, buttonTres, buttonQuatro;
    private Button buttonCinco, buttonSeis, buttonSete, buttonOito, buttonNove;
    private Button buttonSoma, buttonSubtracao, buttonMultiplicacao, buttonDivisao, buttonPorcento;
    private Button buttonIgual, buttonVirgula, buttonDelete, buttonReset;
    private TextView textViewResultado, textViewUltimaExpressao;
    private boolean calculoRealizado = false;
    private String expressaoAtual = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResultado = findViewById(R.id.textViewResultadoID);
        textViewUltimaExpressao = findViewById(R.id.textViewUltimaExpressaoID);

        buttonZero = findViewById(R.id.buttonZeroID);
        buttonUm = findViewById(R.id.buttonUmID);
        buttonDois = findViewById(R.id.buttonDoisID);
        buttonTres = findViewById(R.id.buttonTresID);
        buttonQuatro = findViewById(R.id.buttonQuatroID);
        buttonCinco = findViewById(R.id.buttonCincoID);
        buttonSeis = findViewById(R.id.buttonSeisID);
        buttonSete = findViewById(R.id.buttonSeteID);
        buttonOito = findViewById(R.id.buttonOitoID);
        buttonNove = findViewById(R.id.buttonNoveID);

        buttonSoma = findViewById(R.id.buttonSomaID);
        buttonSubtracao = findViewById(R.id.buttonSubtracaoID);
        buttonMultiplicacao = findViewById(R.id.buttonMultiplicacaoID);
        buttonDivisao = findViewById(R.id.buttonDivisaoID);
        buttonPorcento = findViewById(R.id.buttonPorcentoID);

        buttonIgual = findViewById(R.id.buttonIgualID);
        buttonVirgula = findViewById(R.id.buttonVirgulaID);
        buttonDelete = findViewById(R.id.buttonDeleteID);
        buttonReset = findViewById(R.id.buttonResetID);

        View.OnClickListener tratadorDeDigitacao = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculoRealizado = false;

                Button botaoPressionado = (Button) view;
                expressaoAtual += botaoPressionado.getText().toString();
                textViewResultado.setText(expressaoAtual);
            }
        };

        buttonZero.setOnClickListener(tratadorDeDigitacao);
        buttonUm.setOnClickListener(tratadorDeDigitacao);
        buttonDois.setOnClickListener(tratadorDeDigitacao);
        buttonTres.setOnClickListener(tratadorDeDigitacao);
        buttonQuatro.setOnClickListener(tratadorDeDigitacao);
        buttonCinco.setOnClickListener(tratadorDeDigitacao);
        buttonSeis.setOnClickListener(tratadorDeDigitacao);
        buttonSete.setOnClickListener(tratadorDeDigitacao);
        buttonOito.setOnClickListener(tratadorDeDigitacao);
        buttonNove.setOnClickListener(tratadorDeDigitacao);

        buttonSoma.setOnClickListener(tratadorDeDigitacao);
        buttonSubtracao.setOnClickListener(tratadorDeDigitacao);
        buttonMultiplicacao.setOnClickListener(tratadorDeDigitacao);
        buttonDivisao.setOnClickListener(tratadorDeDigitacao);
        buttonPorcento.setOnClickListener(tratadorDeDigitacao);
        buttonVirgula.setOnClickListener(tratadorDeDigitacao);

        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expressaoAtual = "";
                textViewResultado.setText("0");
                textViewUltimaExpressao.setText("");
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (calculoRealizado) {
                    expressaoAtual = "";
                    textViewResultado.setText("0");
                    textViewUltimaExpressao.setText("");
                    calculoRealizado = false;
                } else {
                    if (expressaoAtual.length() > 0) {
                        expressaoAtual = expressaoAtual.substring(0, expressaoAtual.length() - 1);

                        if (expressaoAtual.isEmpty()) {
                            textViewResultado.setText("0");
                        } else {
                            textViewResultado.setText(expressaoAtual);
                        }
                    }
                }
            }
        });

        buttonIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (expressaoAtual.isEmpty()) return;
                    String expressaoParaAvaliar = expressaoAtual
                            .replace(",", ".")
                            .replace("÷", "/")
                            .replace("%", "/100");

                    Calculable avaliadorExpressao = new ExpressionBuilder(expressaoParaAvaliar).build();
                    Double resultado = avaliadorExpressao.calculate();

                    textViewUltimaExpressao.setText(expressaoAtual);

                    String resultadoString = String.valueOf(resultado).replace(".", ",");

                    if (resultadoString.endsWith(",0")) {
                        resultadoString = resultadoString.replace(",0", "");
                    }

                    textViewResultado.setText(resultadoString);

                    expressaoAtual = resultadoString;
                    calculoRealizado = true;

                } catch (Exception e) {
                    Log.d(TAG, "Erro na expressão: " + e.getMessage());
                    textViewResultado.setText("Erro");
                    expressaoAtual = "";
                }
            }
        });
    }
}