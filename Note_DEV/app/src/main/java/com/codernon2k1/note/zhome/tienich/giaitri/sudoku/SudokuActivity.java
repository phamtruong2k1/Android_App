package com.codernon2k1.note.zhome.tienich.giaitri.sudoku;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.codernon2k1.note.R;
import com.codernon2k1.note.zhome.tienich.giaitri.GameActivity;

import static com.codernon2k1.note.R.color.sudoku_click;
import static com.codernon2k1.note.R.color.sudoku_red;

public class SudokuActivity extends AppCompatActivity {

    ImageView save,exit,delete,goiy;
    TextView textViews_00,textViews_01,textViews_02,textViews_03,textViews_04,textViews_05,textViews_06,textViews_07,textViews_08;
    TextView textViews_10,textViews_11,textViews_12,textViews_13,textViews_14,textViews_15,textViews_16,textViews_17,textViews_18;
    TextView textViews_20,textViews_21,textViews_22,textViews_23,textViews_24,textViews_25,textViews_26,textViews_27,textViews_28;
    TextView textViews_30,textViews_31,textViews_32,textViews_33,textViews_34,textViews_35,textViews_36,textViews_37,textViews_38;
    TextView textViews_40,textViews_41,textViews_42,textViews_43,textViews_44,textViews_45,textViews_46,textViews_47,textViews_48;
    TextView textViews_50,textViews_51,textViews_52,textViews_53,textViews_54,textViews_55,textViews_56,textViews_57,textViews_58;
    TextView textViews_60,textViews_61,textViews_62,textViews_63,textViews_64,textViews_65,textViews_66,textViews_67,textViews_68;
    TextView textViews_70,textViews_71,textViews_72,textViews_73,textViews_74,textViews_75,textViews_76,textViews_77,textViews_78;
    TextView textViews_80,textViews_81,textViews_82,textViews_83,textViews_84,textViews_85,textViews_86,textViews_87,textViews_88;
    public  static SharedPreferences sharedPreferences;
    Button buttons_so_1,buttons_so_2,buttons_so_3,buttons_so_4,buttons_so_5,buttons_so_6,buttons_so_7,buttons_so_8,buttons_so_9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sudoku);

        sharedPreferences = getSharedPreferences("luu_game_sudoku",MODE_PRIVATE);
        String luu_game_sudoku=sharedPreferences.getString("luu","");

        if (luu_game_sudoku.equals("yes")){
            Dialog_choi_tiep();
            khoitao_id();
            Game_Soduku.tao();
            show();
        }
        else{
            khoitao_id();
            Game_Soduku.tao();
            show();
        }
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).
                        setMessage("").setTitle("Thoát game")
                        .setPositiveButton("Xác nhận", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                startActivity(new Intent(getBaseContext(), GameActivity.class));
                            }
                        })
                        .setNegativeButton("Huỷ", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).show();
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).
                        setMessage("").setTitle("Lưu game")
                        .setPositiveButton("Lưu", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                SharedPreferences.Editor  editor = sharedPreferences.edit();
                                editor.putString("luu","yes");
                                editor.commit();
                            }
                        })
                        .setNegativeButton("Bỏ", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                SharedPreferences.Editor  editor = sharedPreferences.edit();
                                editor.putString("luu","no");
                                editor.commit();
                            }
                        }).show();
            }
        });
        {
            textViews_00.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Game_Soduku.show[0][0] == 0) {
                        shownull();
                        checked();
                        textViews_00.setBackgroundResource(R.color.sudoku_click);
                        chon_so(textViews_00);
                        xoaso(textViews_00);
                    }
                }
            });
            textViews_01.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Game_Soduku.show[0][1] == 0) {
                        shownull();
                        checked();
                        textViews_01.setBackgroundResource(R.color.sudoku_click);
                        chon_so(textViews_01);
                        xoaso(textViews_01);
                    }
                }
            });
            textViews_02.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Game_Soduku.show[0][2] == 0) {
                        shownull();
                        checked();
                        textViews_02.setBackgroundResource(sudoku_click);
                        chon_so(textViews_02);
                        xoaso(textViews_02);
                    }
                }
            });
            textViews_03.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Game_Soduku.show[0][3] == 0) {
                        checked();
                        shownull();
                        textViews_03.setBackgroundResource(R.color.sudoku_click);
                        chon_so(textViews_03);
                        xoaso(textViews_03);
                    }
                }
            });
            textViews_04.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Game_Soduku.show[0][4] == 0) {
                        shownull();
                        checked();
                        textViews_04.setBackgroundResource(R.color.sudoku_click);
                        chon_so(textViews_04);
                        xoaso(textViews_04);
                    }
                }
            });
            textViews_05.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Game_Soduku.show[0][5] == 0) {
                        shownull();
                        checked();
                        textViews_05.setBackgroundResource(R.color.sudoku_click);
                        chon_so(textViews_05);
                        xoaso(textViews_05);
                    }
                }
            });
            textViews_06.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Game_Soduku.show[0][6] == 0) {
                        shownull();
                        checked();
                        textViews_06.setBackgroundResource(R.color.sudoku_click);
                        chon_so(textViews_06);
                        xoaso(textViews_06);
                    }
                }
            });
            textViews_07.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Game_Soduku.show[0][7] == 0) {
                        shownull();
                        checked();
                        textViews_07.setBackgroundResource(R.color.sudoku_click);
                        chon_so(textViews_07);
                        xoaso(textViews_07);
                    }
                }
            });
            textViews_08.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Game_Soduku.show[0][8] == 0) {
                        shownull();
                        checked();
                        textViews_08.setBackgroundResource(R.color.sudoku_click);
                        chon_so(textViews_08);
                        xoaso(textViews_08);
                    }
                }
            });
        }
        {
            textViews_10.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Game_Soduku.show[1][0] == 0) {
                        shownull();
                        checked();
                        textViews_10.setBackgroundResource(R.color.sudoku_click);
                        chon_so(textViews_10);
                        xoaso(textViews_10);
                    }
                }
            });
            textViews_11.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Game_Soduku.show[1][1] == 0) {
                        shownull();
                        checked();
                        textViews_11.setBackgroundResource(R.color.sudoku_click);
                        chon_so(textViews_11);
                        xoaso(textViews_11);
                    }
                }
            });
            textViews_12.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Game_Soduku.show[1][2] == 0) {
                        shownull();
                        checked();
                        textViews_12.setBackgroundResource(R.color.sudoku_click);
                        chon_so(textViews_12);
                        xoaso(textViews_12);
                    }
                }
            });
            textViews_13.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Game_Soduku.show[1][3] == 0) {
                        checked();
                        shownull();
                        textViews_13.setBackgroundResource(R.color.sudoku_click);
                        chon_so(textViews_13);
                        xoaso(textViews_13);
                    }
                }
            });
            textViews_14.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Game_Soduku.show[1][4] == 0) {
                        shownull();
                        checked();
                        textViews_14.setBackgroundResource(R.color.sudoku_click);
                        chon_so(textViews_14);
                        xoaso(textViews_14);
                    }
                }
            });
            textViews_15.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Game_Soduku.show[1][5] == 0) {
                        shownull();
                        checked();
                        textViews_15.setBackgroundResource(R.color.sudoku_click);
                        chon_so(textViews_15);
                        xoaso(textViews_15);
                    }
                }
            });
            textViews_16.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Game_Soduku.show[1][6] == 0) {
                        shownull();
                        checked();
                        textViews_16.setBackgroundResource(R.color.sudoku_click);
                        chon_so(textViews_16);
                        xoaso(textViews_16);
                    }
                }
            });
            textViews_17.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Game_Soduku.show[1][7] == 0) {
                        shownull();
                        checked();
                        textViews_17.setBackgroundResource(R.color.sudoku_click);
                        chon_so(textViews_17);
                        xoaso(textViews_17);
                    }
                }
            });
            textViews_18.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Game_Soduku.show[1][8] == 0) {
                        shownull();
                        checked();
                        textViews_18.setBackgroundResource(R.color.sudoku_click);
                        chon_so(textViews_18);
                        xoaso(textViews_18);
                    }
                }
            });
        }
        {
            textViews_20.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Game_Soduku.show[2][0] == 0) {
                        shownull();
                        checked();
                        textViews_20.setBackgroundResource(R.color.sudoku_click);
                        chon_so(textViews_20);
                        xoaso(textViews_20);
                    }
                }
            });
            textViews_21.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Game_Soduku.show[2][1] == 0) {
                        shownull();
                        checked();
                        textViews_21.setBackgroundResource(R.color.sudoku_click);
                        chon_so(textViews_21);
                        xoaso(textViews_21);
                    }
                }
            });
            textViews_22.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Game_Soduku.show[2][2] == 0) {
                        shownull();
                        checked();
                        textViews_22.setBackgroundResource(R.color.sudoku_click);
                        chon_so(textViews_22);
                        xoaso(textViews_22);
                    }
                }
            });
            textViews_23.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Game_Soduku.show[2][3] == 0) {
                        checked();
                        shownull();
                        textViews_23.setBackgroundResource(R.color.sudoku_click);
                        chon_so(textViews_23);
                        xoaso(textViews_23);
                    }
                }
            });
            textViews_24.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Game_Soduku.show[2][4] == 0) {
                        shownull();
                        checked();
                        textViews_24.setBackgroundResource(R.color.sudoku_click);
                        chon_so(textViews_24);
                        xoaso(textViews_24);
                    }
                }
            });
            textViews_25.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Game_Soduku.show[2][5] == 0) {
                        shownull();
                        checked();
                        textViews_25.setBackgroundResource(R.color.sudoku_click);
                        chon_so(textViews_25);
                        xoaso(textViews_25);
                    }
                }
            });
            textViews_26.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Game_Soduku.show[2][6] == 0) {
                        shownull();
                        checked();
                        textViews_26.setBackgroundResource(R.color.sudoku_click);
                        chon_so(textViews_26);
                        xoaso(textViews_26);
                    }
                }
            });
            textViews_27.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Game_Soduku.show[2][7] == 0) {
                        shownull();
                        checked();
                        textViews_27.setBackgroundResource(R.color.sudoku_click);
                        chon_so(textViews_27);
                        xoaso(textViews_27);
                    }
                }
            });
            textViews_28.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Game_Soduku.show[2][8] == 0) {
                        shownull();
                        checked();
                        textViews_28.setBackgroundResource(R.color.sudoku_click);
                        chon_so(textViews_28);
                        xoaso(textViews_28);
                    }
                }
            });
        }
        {
            textViews_30.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Game_Soduku.show[3][0] == 0) {
                        shownull();
                        checked();
                        textViews_30.setBackgroundResource(R.color.sudoku_click);
                        chon_so(textViews_30);
                        xoaso(textViews_30);
                    }
                }
            });
            textViews_31.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Game_Soduku.show[3][1] == 0) {
                        shownull();
                        checked();
                        textViews_31.setBackgroundResource(R.color.sudoku_click);
                        chon_so(textViews_31);
                        xoaso(textViews_31);
                    }
                }
            });
            textViews_32.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Game_Soduku.show[3][2] == 0) {
                        shownull();
                        checked();
                        textViews_32.setBackgroundResource(R.color.sudoku_click);
                        chon_so(textViews_32);
                        xoaso(textViews_32);
                    }
                }
            });
            textViews_33.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Game_Soduku.show[3][3] == 0) {
                        checked();
                        shownull();
                        textViews_33.setBackgroundResource(R.color.sudoku_click);
                        chon_so(textViews_33);
                        xoaso(textViews_33);
                    }
                }
            });
            textViews_34.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Game_Soduku.show[3][4] == 0) {
                        shownull();
                        checked();
                        textViews_34.setBackgroundResource(R.color.sudoku_click);
                        chon_so(textViews_34);
                        xoaso(textViews_34);
                    }
                }
            });
            textViews_35.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Game_Soduku.show[3][5] == 0) {
                        shownull();
                        checked();
                        textViews_35.setBackgroundResource(R.color.sudoku_click);
                        chon_so(textViews_35);
                        xoaso(textViews_35);
                    }
                }
            });
            textViews_36.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Game_Soduku.show[3][6] == 0) {
                        shownull();
                        checked();
                        textViews_36.setBackgroundResource(R.color.sudoku_click);
                        chon_so(textViews_36);
                        xoaso(textViews_36);
                    }
                }
            });
            textViews_37.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Game_Soduku.show[3][7] == 0) {
                        shownull();
                        checked();
                        textViews_37.setBackgroundResource(R.color.sudoku_click);
                        chon_so(textViews_37);
                        xoaso(textViews_37);
                    }
                }
            });
            textViews_38.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Game_Soduku.show[3][8] == 0) {
                        shownull();
                        checked();
                        textViews_38.setBackgroundResource(R.color.sudoku_click);
                        chon_so(textViews_38);
                        xoaso(textViews_38);
                    }
                }
            });
        }
        {
            textViews_40.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Game_Soduku.show[4][0] == 0) {
                        shownull();
                        checked();
                        textViews_40.setBackgroundResource(R.color.sudoku_click);
                        chon_so(textViews_40);
                        xoaso(textViews_40);
                    }
                }
            });
            textViews_41.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Game_Soduku.show[4][1] == 0) {
                        shownull();
                        checked();
                        textViews_41.setBackgroundResource(R.color.sudoku_click);
                        chon_so(textViews_41);
                        xoaso(textViews_41);
                    }
                }
            });
            textViews_42.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Game_Soduku.show[4][2] == 0) {
                        shownull();
                        checked();
                        textViews_42.setBackgroundResource(R.color.sudoku_click);
                        chon_so(textViews_42);
                        xoaso(textViews_42);
                    }
                }
            });
            textViews_43.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Game_Soduku.show[4][3] == 0) {
                        checked();
                        shownull();
                        textViews_43.setBackgroundResource(R.color.sudoku_click);
                        chon_so(textViews_43);
                        xoaso(textViews_43);
                    }
                }
            });
            textViews_44.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Game_Soduku.show[4][4] == 0) {
                        shownull();
                        checked();
                        textViews_44.setBackgroundResource(R.color.sudoku_click);
                        chon_so(textViews_44);
                        xoaso(textViews_44);
                    }
                }
            });
            textViews_45.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Game_Soduku.show[4][5] == 0) {
                        shownull();
                        checked();
                        textViews_45.setBackgroundResource(R.color.sudoku_click);
                        chon_so(textViews_45);
                        xoaso(textViews_45);
                    }
                }
            });
            textViews_46.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Game_Soduku.show[4][6] == 0) {
                        shownull();
                        checked();
                        textViews_46.setBackgroundResource(R.color.sudoku_click);
                        chon_so(textViews_46);
                        xoaso(textViews_46);
                    }
                }
            });
            textViews_47.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Game_Soduku.show[4][7] == 0) {
                        shownull();
                        checked();
                        textViews_47.setBackgroundResource(R.color.sudoku_click);
                        chon_so(textViews_47);
                        xoaso(textViews_47);
                    }
                }
            });
            textViews_48.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Game_Soduku.show[4][8] == 0) {
                        shownull();
                        checked();
                        textViews_48.setBackgroundResource(R.color.sudoku_click);
                        chon_so(textViews_48);
                        xoaso(textViews_48);
                    }
                }
            });
        }
        {
            textViews_50.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Game_Soduku.show[5][0] == 0) {
                        shownull();
                        checked();
                        textViews_50.setBackgroundResource(R.color.sudoku_click);
                        chon_so(textViews_50);
                        xoaso(textViews_50);
                    }
                }
            });
            textViews_51.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Game_Soduku.show[5][1] == 0) {
                        shownull();
                        checked();
                        textViews_51.setBackgroundResource(R.color.sudoku_click);
                        chon_so(textViews_51);
                        xoaso(textViews_51);
                    }
                }
            });
            textViews_52.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Game_Soduku.show[5][2] == 0) {
                        shownull();
                        checked();
                        textViews_52.setBackgroundResource(R.color.sudoku_click);
                        chon_so(textViews_52);
                        xoaso(textViews_52);
                    }
                }
            });
            textViews_53.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Game_Soduku.show[5][3] == 0) {
                        checked();
                        shownull();
                        textViews_53.setBackgroundResource(R.color.sudoku_click);
                        chon_so(textViews_53);
                        xoaso(textViews_53);
                    }
                }
            });
            textViews_54.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Game_Soduku.show[5][4] == 0) {
                        shownull();
                        checked();
                        textViews_54.setBackgroundResource(R.color.sudoku_click);
                        chon_so(textViews_54);
                        xoaso(textViews_54);
                    }
                }
            });
            textViews_55.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Game_Soduku.show[5][5] == 0) {
                        shownull();
                        checked();
                        textViews_55.setBackgroundResource(R.color.sudoku_click);
                        chon_so(textViews_55);
                        xoaso(textViews_55);
                    }
                }
            });
            textViews_56.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Game_Soduku.show[5][6] == 0) {
                        shownull();
                        checked();
                        textViews_56.setBackgroundResource(R.color.sudoku_click);
                        chon_so(textViews_56);
                        xoaso(textViews_56);
                    }
                }
            });
            textViews_57.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Game_Soduku.show[5][7] == 0) {
                        shownull();
                        checked();
                        textViews_57.setBackgroundResource(R.color.sudoku_click);
                        chon_so(textViews_57);
                        xoaso(textViews_57);
                    }
                }
            });
            textViews_58.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Game_Soduku.show[5][8] == 0) {
                        shownull();
                        checked();
                        textViews_58.setBackgroundResource(R.color.sudoku_click);
                        chon_so(textViews_58);
                        xoaso(textViews_58);
                    }
                }
            });
        }
        {
            textViews_60.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Game_Soduku.show[6][0] == 0) {
                        shownull();
                        checked();
                        textViews_60.setBackgroundResource(R.color.sudoku_click);
                        chon_so(textViews_60);
                        xoaso(textViews_60);
                    }
                }
            });
            textViews_61.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Game_Soduku.show[6][1] == 0) {
                        shownull();
                        checked();
                        textViews_61.setBackgroundResource(R.color.sudoku_click);
                        chon_so(textViews_61);
                        xoaso(textViews_61);
                    }
                }
            });
            textViews_62.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Game_Soduku.show[6][2] == 0) {
                        shownull();
                        checked();
                        textViews_62.setBackgroundResource(R.color.sudoku_click);
                        chon_so(textViews_62);
                        xoaso(textViews_62);
                    }
                }
            });
            textViews_63.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Game_Soduku.show[6][3] == 0) {
                        checked();
                        shownull();
                        textViews_63.setBackgroundResource(R.color.sudoku_click);
                        chon_so(textViews_63);
                        xoaso(textViews_63);
                    }
                }
            });
            textViews_64.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Game_Soduku.show[6][4] == 0) {
                        shownull();
                        checked();
                        textViews_64.setBackgroundResource(R.color.sudoku_click);
                        chon_so(textViews_64);
                        xoaso(textViews_64);
                    }
                }
            });
            textViews_65.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Game_Soduku.show[6][5] == 0) {
                        shownull();
                        checked();
                        textViews_65.setBackgroundResource(R.color.sudoku_click);
                        chon_so(textViews_65);
                        xoaso(textViews_65);
                    }
                }
            });
            textViews_66.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Game_Soduku.show[6][6] == 0) {
                        shownull();
                        checked();
                        textViews_66.setBackgroundResource(R.color.sudoku_click);
                        chon_so(textViews_66);
                        xoaso(textViews_66);
                    }
                }
            });
            textViews_67.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Game_Soduku.show[6][7] == 0) {
                        shownull();
                        checked();
                        textViews_67.setBackgroundResource(R.color.sudoku_click);
                        chon_so(textViews_67);
                        xoaso(textViews_67);
                    }
                }
            });
            textViews_68.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Game_Soduku.show[6][8] == 0) {
                        shownull();
                        checked();
                        textViews_68.setBackgroundResource(R.color.sudoku_click);
                        chon_so(textViews_68);
                        xoaso(textViews_68);
                    }
                }
            });
        }
        {
            textViews_70.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Game_Soduku.show[7][0] == 0) {
                        shownull();
                        checked();
                        textViews_70.setBackgroundResource(R.color.sudoku_click);
                        chon_so(textViews_70);
                        xoaso(textViews_70);
                    }
                }
            });
            textViews_71.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Game_Soduku.show[7][1] == 0) {
                        shownull();
                        checked();
                        textViews_71.setBackgroundResource(R.color.sudoku_click);
                        chon_so(textViews_71);
                        xoaso(textViews_71);
                    }
                }
            });
            textViews_72.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Game_Soduku.show[7][2] == 0) {
                        shownull();
                        checked();
                        textViews_72.setBackgroundResource(R.color.sudoku_click);
                        chon_so(textViews_72);
                        xoaso(textViews_72);
                    }
                }
            });
            textViews_73.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Game_Soduku.show[7][3] == 0) {
                        checked();
                        shownull();
                        textViews_73.setBackgroundResource(R.color.sudoku_click);
                        chon_so(textViews_73);
                        xoaso(textViews_73);
                    }
                }
            });
            textViews_74.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Game_Soduku.show[7][4] == 0) {
                        shownull();
                        checked();
                        textViews_74.setBackgroundResource(R.color.sudoku_click);
                        chon_so(textViews_74);
                        xoaso(textViews_74);
                    }
                }
            });
            textViews_75.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Game_Soduku.show[7][5] == 0) {
                        shownull();
                        checked();
                        textViews_75.setBackgroundResource(R.color.sudoku_click);
                        chon_so(textViews_75);
                        xoaso(textViews_75);
                    }
                }
            });
            textViews_76.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Game_Soduku.show[7][6] == 0) {
                        shownull();
                        checked();
                        textViews_76.setBackgroundResource(R.color.sudoku_click);
                        chon_so(textViews_76);
                        xoaso(textViews_76);
                    }
                }
            });
            textViews_77.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Game_Soduku.show[7][7] == 0) {
                        shownull();
                        checked();
                        textViews_77.setBackgroundResource(R.color.sudoku_click);
                        chon_so(textViews_77);
                        xoaso(textViews_77);
                    }
                }
            });
            textViews_78.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Game_Soduku.show[7][8] == 0) {
                        shownull();
                        checked();
                        textViews_78.setBackgroundResource(R.color.sudoku_click);
                        chon_so(textViews_78);
                        xoaso(textViews_78);
                    }
                }
            });
        }
        {
            textViews_80.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Game_Soduku.show[8][0] == 0) {
                        shownull();
                        checked();
                        textViews_80.setBackgroundResource(R.color.sudoku_click);
                        chon_so(textViews_80);
                        xoaso(textViews_80);
                    }
                }
            });
            textViews_81.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Game_Soduku.show[8][1] == 0) {
                        shownull();
                        checked();
                        textViews_81.setBackgroundResource(R.color.sudoku_click);
                        chon_so(textViews_81);
                        xoaso(textViews_81);
                    }
                }
            });
            textViews_82.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Game_Soduku.show[8][2] == 0) {
                        shownull();
                        checked();
                        textViews_82.setBackgroundResource(R.color.sudoku_click);
                        chon_so(textViews_82);
                        xoaso(textViews_82);
                    }
                }
            });
            textViews_83.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Game_Soduku.show[8][3] == 0) {
                        checked();
                        shownull();
                        textViews_83.setBackgroundResource(R.color.sudoku_click);
                        chon_so(textViews_83);
                        xoaso(textViews_83);
                    }
                }
            });
            textViews_84.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Game_Soduku.show[8][4] == 0) {
                        shownull();
                        checked();
                        textViews_84.setBackgroundResource(R.color.sudoku_click);
                        chon_so(textViews_84);
                        xoaso(textViews_84);
                    }
                }
            });
            textViews_85.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Game_Soduku.show[8][5] == 0) {
                        shownull();
                        checked();
                        textViews_85.setBackgroundResource(R.color.sudoku_click);
                        chon_so(textViews_85);
                        xoaso(textViews_85);
                    }
                }
            });
            textViews_86.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Game_Soduku.show[8][6] == 0) {
                        shownull();
                        checked();
                        textViews_86.setBackgroundResource(R.color.sudoku_click);
                        chon_so(textViews_86);
                        xoaso(textViews_86);
                    }
                }
            });
            textViews_87.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Game_Soduku.show[8][7] == 0) {
                        shownull();
                        checked();
                        textViews_87.setBackgroundResource(R.color.sudoku_click);
                        chon_so(textViews_87);
                        xoaso(textViews_87);
                    }
                }
            });
            textViews_88.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Game_Soduku.show[8][8] == 0) {
                        shownull();
                        checked();
                        textViews_88.setBackgroundResource(R.color.sudoku_click);
                        chon_so(textViews_88);
                        xoaso(textViews_88);
                    }
                }
            });
        }
    }

    private void Dialog_choi_tiep(){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_choi_tiep_sudoku);
        Button yes = dialog.findViewById(R.id.sudoku_choi_tiep_yes);
        Button no = dialog.findViewById(R.id.sudoku_choi_tiep_no);
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor  editor = sharedPreferences.edit();
                editor.putString("luu","no");
                editor.commit();
                dialog.dismiss();
                khoitao_id();
                Game_Soduku.tao();
                show();
            }
        });
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor  editor = sharedPreferences.edit();
                editor.putString("luu","no");
                editor.commit();
                khoitao_id();
                Game_Soduku.tao();
                show();
                dialog.dismiss();
                khoitao_id();
                Game_Soduku.tao();
                show();
            }
        });
        dialog.show();
    }

    private void update(){
        String str;
        {
            str = textViews_00.getText().toString();
            if (!str.equals("")){
                int ctm = str.charAt(0) -'0';
                Game_Soduku.play[0][0] = ctm;
            }
            else
                Game_Soduku.play[0][0]=0;
            str = textViews_01.getText().toString();
            if (!str.equals("")){
                int ctm = str.charAt(0) -'0';
                Game_Soduku.play[0][1] = ctm;
            }
            else
                Game_Soduku.play[0][1]=0;
            str = textViews_02.getText().toString();
            if (!str.equals("")){
                int ctm = str.charAt(0) -'0';
                Game_Soduku.play[0][2] = ctm;
            }
            else
                Game_Soduku.play[0][2]=0;
            str = textViews_03.getText().toString();
            if (!str.equals("")){
                int ctm = str.charAt(0) -'0';
                Game_Soduku.play[0][3] = ctm;
            }
            else
                Game_Soduku.play[0][3]=0;
            str = textViews_04.getText().toString();
            if (!str.equals("")){
                int ctm = str.charAt(0) -'0';
                Game_Soduku.play[0][4] = ctm;
            }
            else
                Game_Soduku.play[0][4]=0;
            str = textViews_05.getText().toString();
            if (!str.equals("")){
                int ctm = str.charAt(0) -'0';
                Game_Soduku.play[0][5] = ctm;
            }
            else
                Game_Soduku.play[0][5]=0;
            str = textViews_06.getText().toString();
            if (!str.equals("")){
                int ctm = str.charAt(0) -'0';
                Game_Soduku.play[0][6] = ctm;
            }
            else
                Game_Soduku.play[0][6]=0;
            str = textViews_07.getText().toString();
            if (!str.equals("")){
                int ctm = str.charAt(0) -'0';
                Game_Soduku.play[0][7] = ctm;
            }
            else
                Game_Soduku.play[0][7]=0;
            str = textViews_08.getText().toString();
            if (!str.equals("")){
                int ctm = str.charAt(0) -'0';
                Game_Soduku.play[0][8] = ctm;
            }
            else
                Game_Soduku.play[0][8]=0;
        }
        {
            str = textViews_10.getText().toString();
            if (!str.equals("")){
                int ctm = str.charAt(0) -'0';
                Game_Soduku.play[1][0] = ctm;
            }
            else
                Game_Soduku.play[1][0]=0;
            str = textViews_11.getText().toString();
            if (!str.equals("")){
                int ctm = str.charAt(0) -'0';
                Game_Soduku.play[1][1] = ctm;
            }
            else
                Game_Soduku.play[1][1]=0;
            str = textViews_12.getText().toString();
            if (!str.equals("")){
                int ctm = str.charAt(0) -'0';
                Game_Soduku.play[1][2] = ctm;
            }
            else
                Game_Soduku.play[1][2]=0;
            str = textViews_13.getText().toString();
            if (!str.equals("")){
                int ctm = str.charAt(0) -'0';
                Game_Soduku.play[1][3] = ctm;
            }
            else
                Game_Soduku.play[1][3]=0;
            str = textViews_14.getText().toString();
            if (!str.equals("")){
                int ctm = str.charAt(0) -'0';
                Game_Soduku.play[1][4] = ctm;
            }
            else
                Game_Soduku.play[1][4]=0;
            str = textViews_15.getText().toString();
            if (!str.equals("")){
                int ctm = str.charAt(0) -'0';
                Game_Soduku.play[1][5] = ctm;
            }
            else
                Game_Soduku.play[1][5]=0;
            str = textViews_16.getText().toString();
            if (!str.equals("")){
                int ctm = str.charAt(0) -'0';
                Game_Soduku.play[1][6] = ctm;
            }
            else
                Game_Soduku.play[1][6]=0;
            str = textViews_17.getText().toString();
            if (!str.equals("")){
                int ctm = str.charAt(0) -'0';
                Game_Soduku.play[1][7] = ctm;
            }
            else
                Game_Soduku.play[1][7]=0;
            str = textViews_18.getText().toString();
            if (!str.equals("")){
                int ctm = str.charAt(0) -'0';
                Game_Soduku.play[1][8] = ctm;
            }
            else
                Game_Soduku.play[1][8]=0;
        }
        {
            str = textViews_20.getText().toString();
            if (!str.equals("")){
                int ctm = str.charAt(0) -'0';
                Game_Soduku.play[2][0] = ctm;
            }
            else
                Game_Soduku.play[2][0]=0;
            str = textViews_21.getText().toString();
            if (!str.equals("")){
                int ctm = str.charAt(0) -'0';
                Game_Soduku.play[2][1] = ctm;
            }
            else
                Game_Soduku.play[2][1]=0;
            str = textViews_22.getText().toString();
            if (!str.equals("")){
                int ctm = str.charAt(0) -'0';
                Game_Soduku.play[2][2] = ctm;
            }
            else
                Game_Soduku.play[2][2]=0;
            str = textViews_23.getText().toString();
            if (!str.equals("")){
                int ctm = str.charAt(0) -'0';
                Game_Soduku.play[2][3] = ctm;
            }
            else
                Game_Soduku.play[2][3]=0;
            str = textViews_24.getText().toString();
            if (!str.equals("")){
                int ctm = str.charAt(0) -'0';
                Game_Soduku.play[2][4] = ctm;
            }
            else
                Game_Soduku.play[2][4]=0;
            str = textViews_25.getText().toString();
            if (!str.equals("")){
                int ctm = str.charAt(0) -'0';
                Game_Soduku.play[2][5] = ctm;
            }
            else
                Game_Soduku.play[2][5]=0;
            str = textViews_26.getText().toString();
            if (!str.equals("")){
                int ctm = str.charAt(0) -'0';
                Game_Soduku.play[2][6] = ctm;
            }
            else
                Game_Soduku.play[2][6]=0;
            str = textViews_27.getText().toString();
            if (!str.equals("")){
                int ctm = str.charAt(0) -'0';
                Game_Soduku.play[2][7] = ctm;
            }
            else
                Game_Soduku.play[2][7]=0;
            str = textViews_28.getText().toString();
            if (!str.equals("")){
                int ctm = str.charAt(0) -'0';
                Game_Soduku.play[2][8] = ctm;
            }
            else
                Game_Soduku.play[2][8]=0;
        }
        {
            str = textViews_30.getText().toString();
            if (!str.equals("")){
                int ctm = str.charAt(0) -'0';
                Game_Soduku.play[3][0] = ctm;
            }
            else
                Game_Soduku.play[3][0]=0;
            str = textViews_31.getText().toString();
            if (!str.equals("")){
                int ctm = str.charAt(0) -'0';
                Game_Soduku.play[3][1] = ctm;
            }
            else
                Game_Soduku.play[3][1]=0;
            str = textViews_32.getText().toString();
            if (!str.equals("")){
                int ctm = str.charAt(0) -'0';
                Game_Soduku.play[3][2] = ctm;
            }
            else
                Game_Soduku.play[3][2]=0;
            str = textViews_33.getText().toString();
            if (!str.equals("")){
                int ctm = str.charAt(0) -'0';
                Game_Soduku.play[3][3] = ctm;
            }
            else
                Game_Soduku.play[3][3]=0;
            str = textViews_34.getText().toString();
            if (!str.equals("")){
                int ctm = str.charAt(0) -'0';
                Game_Soduku.play[3][4] = ctm;
            }
            else
                Game_Soduku.play[3][4]=0;
            str = textViews_35.getText().toString();
            if (!str.equals("")){
                int ctm = str.charAt(0) -'0';
                Game_Soduku.play[3][5] = ctm;
            }
            else
                Game_Soduku.play[3][5]=0;
            str = textViews_36.getText().toString();
            if (!str.equals("")){
                int ctm = str.charAt(0) -'0';
                Game_Soduku.play[3][6] = ctm;
            }
            else
                Game_Soduku.play[3][6]=0;
            str = textViews_37.getText().toString();
            if (!str.equals("")){
                int ctm = str.charAt(0) -'0';
                Game_Soduku.play[3][7] = ctm;
            }
            else
                Game_Soduku.play[3][7]=0;
            str = textViews_38.getText().toString();
            if (!str.equals("")){
                int ctm = str.charAt(0) -'0';
                Game_Soduku.play[3][8] = ctm;
            }
            else
                Game_Soduku.play[3][8]=0;
        }
        {
            str = textViews_40.getText().toString();
            if (!str.equals("")){
                int ctm = str.charAt(0) -'0';
                Game_Soduku.play[4][0] = ctm;
            }
            else
                Game_Soduku.play[4][0]=0;
            str = textViews_41.getText().toString();
            if (!str.equals("")){
                int ctm = str.charAt(0) -'0';
                Game_Soduku.play[4][1] = ctm;
            }
            else
                Game_Soduku.play[4][1]=0;
            str = textViews_42.getText().toString();
            if (!str.equals("")){
                int ctm = str.charAt(0) -'0';
                Game_Soduku.play[4][2] = ctm;
            }
            else
                Game_Soduku.play[4][2]=0;
            str = textViews_43.getText().toString();
            if (!str.equals("")){
                int ctm = str.charAt(0) -'0';
                Game_Soduku.play[4][3] = ctm;
            }
            else
                Game_Soduku.play[4][3]=0;
            str = textViews_44.getText().toString();
            if (!str.equals("")){
                int ctm = str.charAt(0) -'0';
                Game_Soduku.play[4][4] = ctm;
            }
            else
                Game_Soduku.play[4][4]=0;
            str = textViews_45.getText().toString();
            if (!str.equals("")){
                int ctm = str.charAt(0) -'0';
                Game_Soduku.play[4][5] = ctm;
            }
            else
                Game_Soduku.play[4][5]=0;
            str = textViews_46.getText().toString();
            if (!str.equals("")){
                int ctm = str.charAt(0) -'0';
                Game_Soduku.play[4][6] = ctm;
            }
            else
                Game_Soduku.play[4][6]=0;
            str = textViews_47.getText().toString();
            if (!str.equals("")){
                int ctm = str.charAt(0) -'0';
                Game_Soduku.play[4][7] = ctm;
            }
            else
                Game_Soduku.play[4][7]=0;
            str = textViews_48.getText().toString();
            if (!str.equals("")){
                int ctm = str.charAt(0) -'0';
                Game_Soduku.play[4][8] = ctm;
            }
            else
                Game_Soduku.play[4][8]=0;
        }
        {
            str = textViews_50.getText().toString();
            if (!str.equals("")){
                int ctm = str.charAt(0) -'0';
                Game_Soduku.play[5][0] = ctm;
            }
            else
                Game_Soduku.play[5][0]=0;
            str = textViews_51.getText().toString();
            if (!str.equals("")){
                int ctm = str.charAt(0) -'0';
                Game_Soduku.play[5][1] = ctm;
            }
            else
                Game_Soduku.play[5][1]=0;
            str = textViews_52.getText().toString();
            if (!str.equals("")){
                int ctm = str.charAt(0) -'0';
                Game_Soduku.play[5][2] = ctm;
            }
            else
                Game_Soduku.play[5][2]=0;
            str = textViews_53.getText().toString();
            if (!str.equals("")){
                int ctm = str.charAt(0) -'0';
                Game_Soduku.play[5][3] = ctm;
            }
            else
                Game_Soduku.play[5][3]=0;
            str = textViews_54.getText().toString();
            if (!str.equals("")){
                int ctm = str.charAt(0) -'0';
                Game_Soduku.play[5][4] = ctm;
            }
            else
                Game_Soduku.play[5][4]=0;
            str = textViews_55.getText().toString();
            if (!str.equals("")){
                int ctm = str.charAt(0) -'0';
                Game_Soduku.play[5][5] = ctm;
            }
            else
                Game_Soduku.play[5][5]=0;
            str = textViews_56.getText().toString();
            if (!str.equals("")){
                int ctm = str.charAt(0) -'0';
                Game_Soduku.play[5][6] = ctm;
            }
            else
                Game_Soduku.play[5][6]=0;
            str = textViews_57.getText().toString();
            if (!str.equals("")){
                int ctm = str.charAt(0) -'0';
                Game_Soduku.play[5][7] = ctm;
            }
            else
                Game_Soduku.play[5][7]=0;
            str = textViews_58.getText().toString();
            if (!str.equals("")){
                int ctm = str.charAt(0) -'0';
                Game_Soduku.play[5][8] = ctm;
            }
            else
                Game_Soduku.play[5][8]=0;
        }
        {
            str = textViews_60.getText().toString();
            if (!str.equals("")){
                int ctm = str.charAt(0) -'0';
                Game_Soduku.play[6][0] = ctm;
            }
            else
                Game_Soduku.play[6][0]=0;

            str = textViews_61.getText().toString();
            if (!str.equals("")){
                int ctm = str.charAt(0) -'0';
                Game_Soduku.play[6][1] = ctm;
            }
            else
                Game_Soduku.play[6][1]=0;
            str = textViews_62.getText().toString();
            if (!str.equals("")){
                int ctm = str.charAt(0) -'0';
                Game_Soduku.play[6][2] = ctm;
            }
            else
                Game_Soduku.play[6][2]=0;
            str = textViews_63.getText().toString();
            if (!str.equals("")){
                int ctm = str.charAt(0) -'0';
                Game_Soduku.play[6][3] = ctm;
            }
            else
                Game_Soduku.play[6][3]=0;
            str = textViews_64.getText().toString();
            if (!str.equals("")){
                int ctm = str.charAt(0) -'0';
                Game_Soduku.play[6][4] = ctm;
            }
            else
                Game_Soduku.play[6][4]=0;
            str = textViews_65.getText().toString();
            if (!str.equals("")){
                int ctm = str.charAt(0) -'0';
                Game_Soduku.play[6][5] = ctm;
            }
            else
                Game_Soduku.play[6][5]=0;
            str = textViews_66.getText().toString();
            if (!str.equals("")){
                int ctm = str.charAt(0) -'0';
                Game_Soduku.play[6][6] = ctm;
            }
            else
                Game_Soduku.play[6][6]=0;
            str = textViews_67.getText().toString();
            if (!str.equals("")){
                int ctm = str.charAt(0) -'0';
                Game_Soduku.play[6][7] = ctm;
            }
            else
                Game_Soduku.play[6][7]=0;
            str = textViews_68.getText().toString();
            if (!str.equals("")){
                int ctm = str.charAt(0) -'0';
                Game_Soduku.play[6][8] = ctm;
            }
            else
                Game_Soduku.play[6][8]=0;
        }
        {
            str = textViews_70.getText().toString();
            if (!str.equals("")){
                int ctm = str.charAt(0) -'0';
                Game_Soduku.play[7][0] = ctm;
            }
            else
                Game_Soduku.play[7][0]=0;
            str = textViews_71.getText().toString();
            if (!str.equals("")){
                int ctm = str.charAt(0) -'0';
                Game_Soduku.play[7][1] = ctm;
            }
            else
                Game_Soduku.play[7][1]=0;
            str = textViews_72.getText().toString();
            if (!str.equals("")){
                int ctm = str.charAt(0) -'0';
                Game_Soduku.play[7][2] = ctm;
            }
            else
                Game_Soduku.play[7][2]=0;
            str = textViews_73.getText().toString();
            if (!str.equals("")){
                int ctm = str.charAt(0) -'0';
                Game_Soduku.play[7][3] = ctm;
            }
            else
                Game_Soduku.play[7][3]=0;
            str = textViews_74.getText().toString();
            if (!str.equals("")){
                int ctm = str.charAt(0) -'0';
                Game_Soduku.play[7][4] = ctm;
            }
            else
                Game_Soduku.play[7][4]=0;
            str = textViews_75.getText().toString();
            if (!str.equals("")){
                int ctm = str.charAt(0) -'0';
                Game_Soduku.play[7][5] = ctm;
            }
            else
                Game_Soduku.play[7][5]=0;
            str = textViews_76.getText().toString();
            if (!str.equals("")){
                int ctm = str.charAt(0) -'0';
                Game_Soduku.play[7][6] = ctm;
            }
            else
                Game_Soduku.play[7][6]=0;
            str = textViews_77.getText().toString();
            if (!str.equals("")){
                int ctm = str.charAt(0) -'0';
                Game_Soduku.play[7][7] = ctm;
            }
            else
                Game_Soduku.play[7][7]=0;
            str = textViews_78.getText().toString();
            if (!str.equals("")){
                int ctm = str.charAt(0) -'0';
                Game_Soduku.play[7][8] = ctm;
            }
            else
                Game_Soduku.play[7][8]=0;
        }
        {
            str = textViews_80.getText().toString();
            if (!str.equals("")){
                int ctm = str.charAt(0) -'0';
                Game_Soduku.play[8][0] = ctm;
            }
            else
                Game_Soduku.play[8][0]=0;

            str = textViews_81.getText().toString();
            if (!str.equals("")){
                int ctm = str.charAt(0) -'0';
                Game_Soduku.play[8][1] = ctm;
            }
            else
                Game_Soduku.play[8][1]=0;
            str = textViews_82.getText().toString();
            if (!str.equals("")){
                int ctm = str.charAt(0) -'0';
                Game_Soduku.play[8][2] = ctm;
            }
            else
                Game_Soduku.play[8][2]=0;
            str = textViews_83.getText().toString();
            if (!str.equals("")){
                int ctm = str.charAt(0) -'0';
                Game_Soduku.play[8][3] = ctm;
            }
            else
                Game_Soduku.play[8][3]=0;
            str = textViews_84.getText().toString();
            if (!str.equals("")){
                int ctm = str.charAt(0) -'0';
                Game_Soduku.play[8][4] = ctm;
            }
            else
                Game_Soduku.play[8][4]=0;
            str = textViews_85.getText().toString();
            if (!str.equals("")){
                int ctm = str.charAt(0) -'0';
                Game_Soduku.play[8][5] = ctm;
            }
            else
                Game_Soduku.play[8][5]=0;
            str = textViews_86.getText().toString();
            if (!str.equals("")){
                int ctm = str.charAt(0) -'0';
                Game_Soduku.play[8][6] = ctm;
            }
            else
                Game_Soduku.play[8][6]=0;
            str = textViews_87.getText().toString();
            if (!str.equals("")){
                int ctm = str.charAt(0) -'0';
                Game_Soduku.play[8][7] = ctm;
            }
            else
                Game_Soduku.play[8][7]=0;
            str = textViews_88.getText().toString();
            if (!str.equals("")){
                int ctm = str.charAt(0) -'0';
                Game_Soduku.play[8][8] = ctm;
            }
            else
                Game_Soduku.play[8][8]=0;
        }



    }

    @SuppressLint("ResourceAsColor")
    private void checked(){
        int cnt=1;
        {
            //0
            if (Game_Soduku.play[0][0] != 0 && Game_Soduku.play[0][0] != Game_Soduku.ans[0][0])
                textViews_00.setBackgroundResource(sudoku_red);
            if (Game_Soduku.play[0][0] != 0 && Game_Soduku.play[0][0] == Game_Soduku.ans[0][0]){
                textViews_00.setBackground(null);
                cnt+=1;
            }
            //1
            if (Game_Soduku.play[0][1] != 0 && Game_Soduku.play[0][1] != Game_Soduku.ans[0][1])
                textViews_01.setBackgroundResource(sudoku_red);
            if (Game_Soduku.play[0][1] != 0 && Game_Soduku.play[0][1] == Game_Soduku.ans[0][1]){
                textViews_01.setBackground(null);
                cnt+=1;
            }
            //2
            if (Game_Soduku.play[0][2] != 0 && Game_Soduku.play[0][2] != Game_Soduku.ans[0][2])
                textViews_02.setBackgroundResource(sudoku_red);
            if (Game_Soduku.play[0][2] != 0 && Game_Soduku.play[0][2] == Game_Soduku.ans[0][2]){
                textViews_02.setBackground(null);
                cnt+=1;
            }
            //3
            if (Game_Soduku.play[0][3] != 0 && Game_Soduku.play[0][3] != Game_Soduku.ans[0][3])
                textViews_03.setBackgroundResource(sudoku_red);
            if (Game_Soduku.play[0][3] != 0 && Game_Soduku.play[0][3] == Game_Soduku.ans[0][3]){
                textViews_03.setBackground(null);
                cnt+=1;
            }
            //4
            if (Game_Soduku.play[0][4] != 0 && Game_Soduku.play[0][4] != Game_Soduku.ans[0][4])
                textViews_04.setBackgroundResource(sudoku_red);
            if (Game_Soduku.play[0][4] != 0 && Game_Soduku.play[0][4] == Game_Soduku.ans[0][4]){
                textViews_04.setBackground(null);
                cnt+=1;
            }
            //5
            if (Game_Soduku.play[0][5] != 0 && Game_Soduku.play[0][5] != Game_Soduku.ans[0][5])
                textViews_05.setBackgroundResource(sudoku_red);
            if (Game_Soduku.play[0][5] != 0 && Game_Soduku.play[0][5] == Game_Soduku.ans[0][5]){
                textViews_05.setBackground(null);
                cnt+=1;
            }
            //6
            if (Game_Soduku.play[0][6] != 0 && Game_Soduku.play[0][6] != Game_Soduku.ans[0][6])
                textViews_06.setBackgroundResource(sudoku_red);
            if (Game_Soduku.play[0][6] != 0 && Game_Soduku.play[0][6] == Game_Soduku.ans[0][6]) {
                textViews_06.setBackground(null);
                cnt+=1;
            }
            //7
            if (Game_Soduku.play[0][7] != 0 && Game_Soduku.play[0][7] != Game_Soduku.ans[0][7])
                textViews_07.setBackgroundResource(sudoku_red);
            if (Game_Soduku.play[0][7] != 0 && Game_Soduku.play[0][7] == Game_Soduku.ans[0][7]){
                textViews_07.setBackground(null);
                cnt+=1;
            }
            //8
            if (Game_Soduku.play[0][8] != 0 && Game_Soduku.play[0][8] != Game_Soduku.ans[0][8])
                textViews_08.setBackgroundResource(sudoku_red);
            if (Game_Soduku.play[0][8] != 0 && Game_Soduku.play[0][8] == Game_Soduku.ans[0][8]){
                textViews_08.setBackground(null);
                cnt+=1;
            }
        }
        {
            //0
            if (Game_Soduku.play[1][0] != 0 && Game_Soduku.play[1][0] != Game_Soduku.ans[1][0])
                textViews_10.setBackgroundResource(sudoku_red);
            if (Game_Soduku.play[1][0] != 0 && Game_Soduku.play[1][0] == Game_Soduku.ans[1][0]){
                textViews_10.setBackground(null);
                cnt+=1;
            }
            //1
            if (Game_Soduku.play[1][1] != 0 && Game_Soduku.play[1][1] != Game_Soduku.ans[1][1])
                textViews_11.setBackgroundResource(sudoku_red);
            if (Game_Soduku.play[1][1] != 0 && Game_Soduku.play[1][1] == Game_Soduku.ans[1][1]){
                textViews_11.setBackground(null);
                cnt+=1;
            }
            //2
            if (Game_Soduku.play[1][2] != 0 && Game_Soduku.play[1][2] != Game_Soduku.ans[1][2])
                textViews_12.setBackgroundResource(sudoku_red);
            if (Game_Soduku.play[1][2] != 0 && Game_Soduku.play[1][2] == Game_Soduku.ans[1][2]){
                textViews_12.setBackground(null);
                cnt+=1;
            }
            //3
            if (Game_Soduku.play[1][3] != 0 && Game_Soduku.play[1][3] != Game_Soduku.ans[1][3])
                textViews_13.setBackgroundResource(sudoku_red);
            if (Game_Soduku.play[1][3] != 0 && Game_Soduku.play[1][3] == Game_Soduku.ans[1][3]){
                textViews_13.setBackground(null);
                cnt+=1;
            }
            //4
            if (Game_Soduku.play[1][4] != 0 && Game_Soduku.play[1][4] != Game_Soduku.ans[1][4])
                textViews_14.setBackgroundResource(sudoku_red);
            if (Game_Soduku.play[1][4] != 0 && Game_Soduku.play[1][4] == Game_Soduku.ans[1][4]){
                textViews_14.setBackground(null);
                cnt+=1;
            }
            //5
            if (Game_Soduku.play[1][5] != 0 && Game_Soduku.play[1][5] != Game_Soduku.ans[1][5])
                textViews_15.setBackgroundResource(sudoku_red);
            if (Game_Soduku.play[1][5] != 0 && Game_Soduku.play[1][5] == Game_Soduku.ans[1][5]){
                textViews_15.setBackground(null);
                cnt+=1;
            }
            //6
            if (Game_Soduku.play[1][6] != 0 && Game_Soduku.play[1][6] != Game_Soduku.ans[1][6])
                textViews_16.setBackgroundResource(sudoku_red);
            if (Game_Soduku.play[1][6] != 0 && Game_Soduku.play[1][6] == Game_Soduku.ans[1][6]) {
                textViews_16.setBackground(null);
                cnt+=1;
            }
            //7
            if (Game_Soduku.play[1][7] != 0 && Game_Soduku.play[1][7] != Game_Soduku.ans[1][7])
                textViews_17.setBackgroundResource(sudoku_red);
            if (Game_Soduku.play[1][7] != 0 && Game_Soduku.play[1][7] == Game_Soduku.ans[1][7]){
                textViews_17.setBackground(null);
                cnt+=1;
            }
            //8
            if (Game_Soduku.play[1][8] != 0 && Game_Soduku.play[1][8] != Game_Soduku.ans[1][8])
                textViews_18.setBackgroundResource(sudoku_red);
            if (Game_Soduku.play[1][8] != 0 && Game_Soduku.play[1][8] == Game_Soduku.ans[1][8]){
                textViews_18.setBackground(null);
                cnt+=1;
            }
        }
        {
            //0
            if (Game_Soduku.play[2][0] != 0 && Game_Soduku.play[2][0] != Game_Soduku.ans[2][0])
                textViews_20.setBackgroundResource(sudoku_red);
            if (Game_Soduku.play[2][0] != 0 && Game_Soduku.play[2][0] == Game_Soduku.ans[2][0]){
                textViews_20.setBackground(null);
                cnt+=1;
            }
            //1
            if (Game_Soduku.play[2][1] != 0 && Game_Soduku.play[2][1] != Game_Soduku.ans[2][1])
                textViews_21.setBackgroundResource(sudoku_red);
            if (Game_Soduku.play[2][1] != 0 && Game_Soduku.play[2][1] == Game_Soduku.ans[2][1]){
                textViews_21.setBackground(null);
                cnt+=1;
            }
            //2
            if (Game_Soduku.play[2][2] != 0 && Game_Soduku.play[2][2] != Game_Soduku.ans[2][2])
                textViews_22.setBackgroundResource(sudoku_red);
            if (Game_Soduku.play[2][2] != 0 && Game_Soduku.play[2][2] == Game_Soduku.ans[2][2]){
                textViews_22.setBackground(null);
                cnt+=1;
            }
            //3
            if (Game_Soduku.play[2][3] != 0 && Game_Soduku.play[2][3] != Game_Soduku.ans[2][3])
                textViews_23.setBackgroundResource(sudoku_red);
            if (Game_Soduku.play[2][3] != 0 && Game_Soduku.play[2][3] == Game_Soduku.ans[2][3]){
                textViews_23.setBackground(null);
                cnt+=1;
            }
            //4
            if (Game_Soduku.play[2][4] != 0 && Game_Soduku.play[2][4] != Game_Soduku.ans[2][4])
                textViews_24.setBackgroundResource(sudoku_red);
            if (Game_Soduku.play[2][4] != 0 && Game_Soduku.play[2][4] == Game_Soduku.ans[2][4]){
                textViews_24.setBackground(null);
                cnt+=1;
            }
            //5
            if (Game_Soduku.play[2][5] != 0 && Game_Soduku.play[2][5] != Game_Soduku.ans[2][5])
                textViews_25.setBackgroundResource(sudoku_red);
            if (Game_Soduku.play[2][5] != 0 && Game_Soduku.play[2][5] == Game_Soduku.ans[2][5]){
                textViews_25.setBackground(null);
                cnt+=1;
            }
            //6
            if (Game_Soduku.play[2][6] != 0 && Game_Soduku.play[2][6] != Game_Soduku.ans[2][6])
                textViews_26.setBackgroundResource(sudoku_red);
            if (Game_Soduku.play[2][6] != 0 && Game_Soduku.play[2][6] == Game_Soduku.ans[2][6]) {
                textViews_26.setBackground(null);
                cnt+=1;
            }
            //7
            if (Game_Soduku.play[2][7] != 0 && Game_Soduku.play[2][7] != Game_Soduku.ans[2][7])
                textViews_27.setBackgroundResource(sudoku_red);
            if (Game_Soduku.play[2][7] != 0 && Game_Soduku.play[2][7] == Game_Soduku.ans[2][7]){
                textViews_27.setBackground(null);
                cnt+=1;
            }
            //8
            if (Game_Soduku.play[2][8] != 0 && Game_Soduku.play[2][8] != Game_Soduku.ans[2][8])
                textViews_28.setBackgroundResource(sudoku_red);
            if (Game_Soduku.play[2][8] != 0 && Game_Soduku.play[2][8] == Game_Soduku.ans[2][8]){
                textViews_28.setBackground(null);
                cnt+=1;
            }
        }
        {
            //0
            if (Game_Soduku.play[3][0] != 0 && Game_Soduku.play[3][0] != Game_Soduku.ans[3][0])
                textViews_30.setBackgroundResource(sudoku_red);
            if (Game_Soduku.play[3][0] != 0 && Game_Soduku.play[3][0] == Game_Soduku.ans[3][0]){
                textViews_30.setBackground(null);
                cnt+=1;
            }
            //1
            if (Game_Soduku.play[3][1] != 0 && Game_Soduku.play[3][1] != Game_Soduku.ans[3][1])
                textViews_31.setBackgroundResource(sudoku_red);
            if (Game_Soduku.play[3][1] != 0 && Game_Soduku.play[3][1] == Game_Soduku.ans[3][1]){
                textViews_31.setBackground(null);
                cnt+=1;
            }
            //2
            if (Game_Soduku.play[3][2] != 0 && Game_Soduku.play[3][2] != Game_Soduku.ans[3][2])
                textViews_32.setBackgroundResource(sudoku_red);
            if (Game_Soduku.play[3][2] != 0 && Game_Soduku.play[3][2] == Game_Soduku.ans[3][2]){
                textViews_32.setBackground(null);
                cnt+=1;
            }
            //3
            if (Game_Soduku.play[3][3] != 0 && Game_Soduku.play[3][3] != Game_Soduku.ans[3][3])
                textViews_33.setBackgroundResource(sudoku_red);
            if (Game_Soduku.play[3][3] != 0 && Game_Soduku.play[3][3] == Game_Soduku.ans[3][3]){
                textViews_33.setBackground(null);
                cnt+=1;
            }
            //4
            if (Game_Soduku.play[3][4] != 0 && Game_Soduku.play[3][4] != Game_Soduku.ans[3][4])
                textViews_34.setBackgroundResource(sudoku_red);
            if (Game_Soduku.play[3][4] != 0 && Game_Soduku.play[3][4] == Game_Soduku.ans[3][4]){
                textViews_34.setBackground(null);
                cnt+=1;
            }
            //5
            if (Game_Soduku.play[3][5] != 0 && Game_Soduku.play[3][5] != Game_Soduku.ans[3][5])
                textViews_35.setBackgroundResource(sudoku_red);
            if (Game_Soduku.play[3][5] != 0 && Game_Soduku.play[3][5] == Game_Soduku.ans[3][5]){
                textViews_35.setBackground(null);
                cnt+=1;
            }
            //6
            if (Game_Soduku.play[3][6] != 0 && Game_Soduku.play[3][6] != Game_Soduku.ans[3][6])
                textViews_36.setBackgroundResource(sudoku_red);
            if (Game_Soduku.play[3][6] != 0 && Game_Soduku.play[3][6] == Game_Soduku.ans[3][6]) {
                textViews_36.setBackground(null);
                cnt+=1;
            }
            //7
            if (Game_Soduku.play[3][7] != 0 && Game_Soduku.play[3][7] != Game_Soduku.ans[3][7])
                textViews_37.setBackgroundResource(sudoku_red);
            if (Game_Soduku.play[3][7] != 0 && Game_Soduku.play[3][7] == Game_Soduku.ans[3][7]){
                textViews_37.setBackground(null);
                cnt+=1;
            }
            //8
            if (Game_Soduku.play[3][8] != 0 && Game_Soduku.play[3][8] != Game_Soduku.ans[3][8])
                textViews_38.setBackgroundResource(sudoku_red);
            if (Game_Soduku.play[3][8] != 0 && Game_Soduku.play[3][8] == Game_Soduku.ans[3][8]){
                textViews_38.setBackground(null);
                cnt+=1;
            }
        }
        {
            //0
            if (Game_Soduku.play[4][0] != 0 && Game_Soduku.play[4][0] != Game_Soduku.ans[4][0])
                textViews_40.setBackgroundResource(sudoku_red);
            if (Game_Soduku.play[4][0] != 0 && Game_Soduku.play[4][0] == Game_Soduku.ans[4][0]){
                textViews_40.setBackground(null);
                cnt+=1;
            }
            //1
            if (Game_Soduku.play[4][1] != 0 && Game_Soduku.play[4][1] != Game_Soduku.ans[4][1])
                textViews_41.setBackgroundResource(sudoku_red);
            if (Game_Soduku.play[4][1] != 0 && Game_Soduku.play[4][1] == Game_Soduku.ans[4][1]){
                textViews_41.setBackground(null);
                cnt+=1;
            }
            //2
            if (Game_Soduku.play[4][2] != 0 && Game_Soduku.play[4][2] != Game_Soduku.ans[4][2])
                textViews_42.setBackgroundResource(sudoku_red);
            if (Game_Soduku.play[4][2] != 0 && Game_Soduku.play[4][2] == Game_Soduku.ans[4][2]){
                textViews_42.setBackground(null);
                cnt+=1;
            }
            //3
            if (Game_Soduku.play[4][3] != 0 && Game_Soduku.play[4][3] != Game_Soduku.ans[4][3])
                textViews_43.setBackgroundResource(sudoku_red);
            if (Game_Soduku.play[4][3] != 0 && Game_Soduku.play[4][3] == Game_Soduku.ans[4][3]){
                textViews_43.setBackground(null);
                cnt+=1;
            }
            //4
            if (Game_Soduku.play[4][4] != 0 && Game_Soduku.play[4][4] != Game_Soduku.ans[4][4])
                textViews_44.setBackgroundResource(sudoku_red);
            if (Game_Soduku.play[4][4] != 0 && Game_Soduku.play[4][4] == Game_Soduku.ans[4][4]){
                textViews_44.setBackground(null);
                cnt+=1;
            }
            //5
            if (Game_Soduku.play[4][5] != 0 && Game_Soduku.play[4][5] != Game_Soduku.ans[4][5])
                textViews_45.setBackgroundResource(sudoku_red);
            if (Game_Soduku.play[4][5] != 0 && Game_Soduku.play[4][5] == Game_Soduku.ans[4][5]){
                textViews_45.setBackground(null);
                cnt+=1;
            }
            //6
            if (Game_Soduku.play[4][6] != 0 && Game_Soduku.play[4][6] != Game_Soduku.ans[4][6])
                textViews_46.setBackgroundResource(sudoku_red);
            if (Game_Soduku.play[4][6] != 0 && Game_Soduku.play[4][6] == Game_Soduku.ans[4][6]) {
                textViews_46.setBackground(null);
                cnt+=1;
            }
            //7
            if (Game_Soduku.play[4][7] != 0 && Game_Soduku.play[4][7] != Game_Soduku.ans[4][7])
                textViews_47.setBackgroundResource(sudoku_red);
            if (Game_Soduku.play[4][7] != 0 && Game_Soduku.play[4][7] == Game_Soduku.ans[4][7]){
                textViews_47.setBackground(null);
                cnt+=1;
            }
            //8
            if (Game_Soduku.play[4][8] != 0 && Game_Soduku.play[4][8] != Game_Soduku.ans[4][8])
                textViews_48.setBackgroundResource(sudoku_red);
            if (Game_Soduku.play[4][8] != 0 && Game_Soduku.play[4][8] == Game_Soduku.ans[4][8]){
                textViews_48.setBackground(null);
                cnt+=1;
            }
        }
        {
            //0
            if (Game_Soduku.play[5][0] != 0 && Game_Soduku.play[5][0] != Game_Soduku.ans[5][0])
                textViews_50.setBackgroundResource(sudoku_red);
            if (Game_Soduku.play[5][0] != 0 && Game_Soduku.play[5][0] == Game_Soduku.ans[5][0]){
                textViews_50.setBackground(null);
                cnt+=1;
            }
            //1
            if (Game_Soduku.play[5][1] != 0 && Game_Soduku.play[5][1] != Game_Soduku.ans[5][1])
                textViews_51.setBackgroundResource(sudoku_red);
            if (Game_Soduku.play[5][1] != 0 && Game_Soduku.play[5][1] == Game_Soduku.ans[5][1]){
                textViews_51.setBackground(null);
                cnt+=1;
            }
            //2
            if (Game_Soduku.play[5][2] != 0 && Game_Soduku.play[5][2] != Game_Soduku.ans[5][2])
                textViews_52.setBackgroundResource(sudoku_red);
            if (Game_Soduku.play[5][2] != 0 && Game_Soduku.play[5][2] == Game_Soduku.ans[5][2]){
                textViews_52.setBackground(null);
                cnt+=1;
            }
            //3
            if (Game_Soduku.play[5][3] != 0 && Game_Soduku.play[5][3] != Game_Soduku.ans[5][3])
                textViews_53.setBackgroundResource(sudoku_red);
            if (Game_Soduku.play[5][3] != 0 && Game_Soduku.play[5][3] == Game_Soduku.ans[5][3]){
                textViews_53.setBackground(null);
                cnt+=1;
            }
            //4
            if (Game_Soduku.play[5][4] != 0 && Game_Soduku.play[5][4] != Game_Soduku.ans[5][4])
                textViews_54.setBackgroundResource(sudoku_red);
            if (Game_Soduku.play[5][4] != 0 && Game_Soduku.play[5][4] == Game_Soduku.ans[5][4]){
                textViews_54.setBackground(null);
                cnt+=1;
            }
            //5
            if (Game_Soduku.play[5][5] != 0 && Game_Soduku.play[5][5] != Game_Soduku.ans[5][5])
                textViews_55.setBackgroundResource(sudoku_red);
            if (Game_Soduku.play[5][5] != 0 && Game_Soduku.play[5][5] == Game_Soduku.ans[5][5]){
                textViews_55.setBackground(null);
                cnt+=1;
            }
            //6
            if (Game_Soduku.play[5][6] != 0 && Game_Soduku.play[5][6] != Game_Soduku.ans[5][6])
                textViews_56.setBackgroundResource(sudoku_red);
            if (Game_Soduku.play[5][6] != 0 && Game_Soduku.play[5][6] == Game_Soduku.ans[5][6]) {
                textViews_56.setBackground(null);
                cnt+=1;
            }
            //7
            if (Game_Soduku.play[5][7] != 0 && Game_Soduku.play[5][7] != Game_Soduku.ans[5][7])
                textViews_57.setBackgroundResource(sudoku_red);
            if (Game_Soduku.play[5][7] != 0 && Game_Soduku.play[5][7] == Game_Soduku.ans[5][7]){
                textViews_57.setBackground(null);
                cnt+=1;
            }
            //8
            if (Game_Soduku.play[5][8] != 0 && Game_Soduku.play[5][8] != Game_Soduku.ans[5][8])
                textViews_58.setBackgroundResource(sudoku_red);
            if (Game_Soduku.play[5][8] != 0 && Game_Soduku.play[5][8] == Game_Soduku.ans[5][8]){
                textViews_58.setBackground(null);
                cnt+=1;
            }
        }
        {
            //0
            if (Game_Soduku.play[6][0] != 0 && Game_Soduku.play[6][0] != Game_Soduku.ans[6][0])
                textViews_60.setBackgroundResource(sudoku_red);
            if (Game_Soduku.play[6][0] != 0 && Game_Soduku.play[6][0] == Game_Soduku.ans[6][0]){
                textViews_60.setBackground(null);
                cnt+=1;
            }
            //1
            if (Game_Soduku.play[6][1] != 0 && Game_Soduku.play[6][1] != Game_Soduku.ans[6][1])
                textViews_61.setBackgroundResource(sudoku_red);
            if (Game_Soduku.play[6][1] != 0 && Game_Soduku.play[6][1] == Game_Soduku.ans[6][1]){
                textViews_61.setBackground(null);
                cnt+=1;
            }
            //2
            if (Game_Soduku.play[6][2] != 0 && Game_Soduku.play[6][2] != Game_Soduku.ans[6][2])
                textViews_62.setBackgroundResource(sudoku_red);
            if (Game_Soduku.play[6][2] != 0 && Game_Soduku.play[6][2] == Game_Soduku.ans[6][2]){
                textViews_62.setBackground(null);
                cnt+=1;
            }
            //3
            if (Game_Soduku.play[6][3] != 0 && Game_Soduku.play[6][3] != Game_Soduku.ans[6][3])
                textViews_63.setBackgroundResource(sudoku_red);
            if (Game_Soduku.play[6][3] != 0 && Game_Soduku.play[6][3] == Game_Soduku.ans[6][3]){
                textViews_63.setBackground(null);
                cnt+=1;
            }
            //4
            if (Game_Soduku.play[6][4] != 0 && Game_Soduku.play[6][4] != Game_Soduku.ans[6][4])
                textViews_64.setBackgroundResource(sudoku_red);
            if (Game_Soduku.play[6][4] != 0 && Game_Soduku.play[6][4] == Game_Soduku.ans[6][4]){
                textViews_64.setBackground(null);
                cnt+=1;
            }
            //5
            if (Game_Soduku.play[6][5] != 0 && Game_Soduku.play[6][5] != Game_Soduku.ans[6][5])
                textViews_65.setBackgroundResource(sudoku_red);
            if (Game_Soduku.play[6][5] != 0 && Game_Soduku.play[6][5] == Game_Soduku.ans[6][5]){
                textViews_65.setBackground(null);
                cnt+=1;
            }
            //6
            if (Game_Soduku.play[6][6] != 0 && Game_Soduku.play[6][6] != Game_Soduku.ans[6][6])
                textViews_66.setBackgroundResource(sudoku_red);
            if (Game_Soduku.play[6][6] != 0 && Game_Soduku.play[6][6] == Game_Soduku.ans[6][6]) {
                textViews_66.setBackground(null);
                cnt+=1;
            }
            //7
            if (Game_Soduku.play[6][7] != 0 && Game_Soduku.play[6][7] != Game_Soduku.ans[6][7])
                textViews_67.setBackgroundResource(sudoku_red);
            if (Game_Soduku.play[6][7] != 0 && Game_Soduku.play[6][7] == Game_Soduku.ans[6][7]){
                textViews_67.setBackground(null);
                cnt+=1;
            }
            //8
            if (Game_Soduku.play[6][8] != 0 && Game_Soduku.play[6][8] != Game_Soduku.ans[6][8])
                textViews_68.setBackgroundResource(sudoku_red);
            if (Game_Soduku.play[6][8] != 0 && Game_Soduku.play[6][8] == Game_Soduku.ans[6][8]){
                textViews_68.setBackground(null);
                cnt+=1;
            }
        }
        {
            //0
            if (Game_Soduku.play[7][0] != 0 && Game_Soduku.play[7][0] != Game_Soduku.ans[7][0])
                textViews_70.setBackgroundResource(sudoku_red);
            if (Game_Soduku.play[7][0] != 0 && Game_Soduku.play[7][0] == Game_Soduku.ans[7][0]){
                textViews_70.setBackground(null);
                cnt+=1;
            }
            //1
            if (Game_Soduku.play[7][1] != 0 && Game_Soduku.play[7][1] != Game_Soduku.ans[7][1])
                textViews_71.setBackgroundResource(sudoku_red);
            if (Game_Soduku.play[7][1] != 0 && Game_Soduku.play[7][1] == Game_Soduku.ans[7][1]){
                textViews_71.setBackground(null);
                cnt+=1;
            }
            //2
            if (Game_Soduku.play[7][2] != 0 && Game_Soduku.play[7][2] != Game_Soduku.ans[7][2])
                textViews_72.setBackgroundResource(sudoku_red);
            if (Game_Soduku.play[7][2] != 0 && Game_Soduku.play[7][2] == Game_Soduku.ans[7][2]){
                textViews_72.setBackground(null);
                cnt+=1;
            }
            //3
            if (Game_Soduku.play[7][3] != 0 && Game_Soduku.play[7][3] != Game_Soduku.ans[7][3])
                textViews_73.setBackgroundResource(sudoku_red);
            if (Game_Soduku.play[7][3] != 0 && Game_Soduku.play[7][3] == Game_Soduku.ans[7][3]){
                textViews_73.setBackground(null);
                cnt+=1;
            }
            //4
            if (Game_Soduku.play[7][4] != 0 && Game_Soduku.play[7][4] != Game_Soduku.ans[7][4])
                textViews_74.setBackgroundResource(sudoku_red);
            if (Game_Soduku.play[7][4] != 0 && Game_Soduku.play[7][4] == Game_Soduku.ans[7][4]){
                textViews_74.setBackground(null);
                cnt+=1;
            }
            //5
            if (Game_Soduku.play[7][5] != 0 && Game_Soduku.play[7][5] != Game_Soduku.ans[7][5])
                textViews_75.setBackgroundResource(sudoku_red);
            if (Game_Soduku.play[7][5] != 0 && Game_Soduku.play[7][5] == Game_Soduku.ans[7][5]){
                textViews_75.setBackground(null);
                cnt+=1;
            }
            //6
            if (Game_Soduku.play[7][6] != 0 && Game_Soduku.play[7][6] != Game_Soduku.ans[7][6])
                textViews_76.setBackgroundResource(sudoku_red);
            if (Game_Soduku.play[7][6] != 0 && Game_Soduku.play[7][6] == Game_Soduku.ans[7][6]) {
                textViews_76.setBackground(null);
                cnt+=1;
            }
            //7
            if (Game_Soduku.play[7][7] != 0 && Game_Soduku.play[7][7] != Game_Soduku.ans[7][7])
                textViews_77.setBackgroundResource(sudoku_red);
            if (Game_Soduku.play[7][7] != 0 && Game_Soduku.play[7][7] == Game_Soduku.ans[7][7]){
                textViews_77.setBackground(null);
                cnt+=1;
            }
            //8
            if (Game_Soduku.play[7][8] != 0 && Game_Soduku.play[7][8] != Game_Soduku.ans[7][8])
                textViews_78.setBackgroundResource(sudoku_red);
            if (Game_Soduku.play[7][8] != 0 && Game_Soduku.play[7][8] == Game_Soduku.ans[7][8]){
                textViews_78.setBackground(null);
                cnt+=1;
            }
        }
        {
            //0
            if (Game_Soduku.play[8][0] != 0 && Game_Soduku.play[8][0] != Game_Soduku.ans[8][0])
                textViews_80.setBackgroundResource(sudoku_red);
            if (Game_Soduku.play[8][0] != 0 && Game_Soduku.play[8][0] == Game_Soduku.ans[8][0]){
                textViews_80.setBackground(null);
                cnt+=1;
            }
            //1
            if (Game_Soduku.play[8][1] != 0 && Game_Soduku.play[8][1] != Game_Soduku.ans[8][1])
                textViews_81.setBackgroundResource(sudoku_red);
            if (Game_Soduku.play[8][1] != 0 && Game_Soduku.play[8][1] == Game_Soduku.ans[8][1]){
                textViews_81.setBackground(null);
                cnt+=1;
            }
            //2
            if (Game_Soduku.play[8][2] != 0 && Game_Soduku.play[8][2] != Game_Soduku.ans[8][2])
                textViews_82.setBackgroundResource(sudoku_red);
            if (Game_Soduku.play[8][2] != 0 && Game_Soduku.play[8][2] == Game_Soduku.ans[8][2]){
                textViews_82.setBackground(null);
                cnt+=1;
            }
            //3
            if (Game_Soduku.play[8][3] != 0 && Game_Soduku.play[8][3] != Game_Soduku.ans[8][3])
                textViews_83.setBackgroundResource(sudoku_red);
            if (Game_Soduku.play[8][3] != 0 && Game_Soduku.play[8][3] == Game_Soduku.ans[8][3]){
                textViews_83.setBackground(null);
                cnt+=1;
            }
            //4
            if (Game_Soduku.play[8][4] != 0 && Game_Soduku.play[8][4] != Game_Soduku.ans[8][4])
                textViews_84.setBackgroundResource(sudoku_red);
            if (Game_Soduku.play[8][4] != 0 && Game_Soduku.play[8][4] == Game_Soduku.ans[8][4]){
                textViews_84.setBackground(null);
                cnt+=1;
            }
            //5
            if (Game_Soduku.play[8][5] != 0 && Game_Soduku.play[8][5] != Game_Soduku.ans[8][5])
                textViews_85.setBackgroundResource(sudoku_red);
            if (Game_Soduku.play[8][5] != 0 && Game_Soduku.play[8][5] == Game_Soduku.ans[8][5]){
                textViews_85.setBackground(null);
                cnt+=1;
            }
            //6
            if (Game_Soduku.play[8][6] != 0 && Game_Soduku.play[8][6] != Game_Soduku.ans[8][6])
                textViews_86.setBackgroundResource(sudoku_red);
            if (Game_Soduku.play[8][6] != 0 && Game_Soduku.play[8][6] == Game_Soduku.ans[8][6]) {
                textViews_86.setBackground(null);
                cnt+=1;
            }
            //7
            if (Game_Soduku.play[8][7] != 0 && Game_Soduku.play[8][7] != Game_Soduku.ans[8][7])
                textViews_87.setBackgroundResource(sudoku_red);
            if (Game_Soduku.play[8][7] != 0 && Game_Soduku.play[8][7] == Game_Soduku.ans[8][7]){
                textViews_87.setBackground(null);
                cnt+=1;
            }
            //8
            if (Game_Soduku.play[8][8] != 0 && Game_Soduku.play[8][8] != Game_Soduku.ans[8][8])
                textViews_88.setBackgroundResource(sudoku_red);
            if (Game_Soduku.play[8][8] != 0 && Game_Soduku.play[8][8] == Game_Soduku.ans[0][8]){
                textViews_88.setBackground(null);
                cnt+=1;
            }
        }

        System.out.println(cnt);
        if (cnt==81){
            Toast.makeText(this,"Win",Toast.LENGTH_LONG).show();
        }
    }

    private void show(){
        {
            if (Game_Soduku.show[0][0] != 0)
                textViews_00.setText(Game_Soduku.show[0][0] + "");
            if (Game_Soduku.show[0][1] != 0)
                textViews_01.setText(Game_Soduku.show[0][1] + "");
            if (Game_Soduku.show[0][2] != 0)
                textViews_02.setText(Game_Soduku.show[0][2] + "");
            if (Game_Soduku.show[0][3] != 0)
                textViews_03.setText(Game_Soduku.show[0][3] + "");
            if (Game_Soduku.show[0][4] != 0)
                textViews_04.setText(Game_Soduku.show[0][4] + "");
            if (Game_Soduku.show[0][5] != 0)
                textViews_05.setText(Game_Soduku.show[0][5] + "");
            if (Game_Soduku.show[0][6] != 0)
                textViews_06.setText(Game_Soduku.show[0][6] + "");
            if (Game_Soduku.show[0][7] != 0)
                textViews_07.setText(Game_Soduku.show[0][7] + "");
            if (Game_Soduku.show[0][8] != 0)
                textViews_08.setText(Game_Soduku.show[0][8] + "");
        }
        {
            if (Game_Soduku.show[1][0] != 0)
                textViews_10.setText(Game_Soduku.show[1][0] + "");
            if (Game_Soduku.show[1][1] != 0)
                textViews_11.setText(Game_Soduku.show[1][1] + "");
            if (Game_Soduku.show[1][2] != 0)
                textViews_12.setText(Game_Soduku.show[1][2] + "");
            if (Game_Soduku.show[1][3] != 0)
                textViews_13.setText(Game_Soduku.show[1][3] + "");
            if (Game_Soduku.show[1][4] != 0)
                textViews_14.setText(Game_Soduku.show[1][4] + "");
            if (Game_Soduku.show[1][5] != 0)
                textViews_15.setText(Game_Soduku.show[1][5] + "");
            if (Game_Soduku.show[1][6] != 0)
                textViews_16.setText(Game_Soduku.show[1][6] + "");
            if (Game_Soduku.show[1][7] != 0)
                textViews_17.setText(Game_Soduku.show[1][7] + "");
            if (Game_Soduku.show[1][8] != 0)
                textViews_18.setText(Game_Soduku.show[1][8] + "");
        }
        {
            if (Game_Soduku.show[2][0] != 0)
                textViews_20.setText(Game_Soduku.show[2][0] + "");
            if (Game_Soduku.show[2][1] != 0)
                textViews_21.setText(Game_Soduku.show[2][1] + "");
            if (Game_Soduku.show[2][2] != 0)
                textViews_22.setText(Game_Soduku.show[2][2] + "");
            if (Game_Soduku.show[2][3] != 0)
                textViews_23.setText(Game_Soduku.show[2][3] + "");
            if (Game_Soduku.show[2][4] != 0)
                textViews_24.setText(Game_Soduku.show[2][4] + "");
            if (Game_Soduku.show[2][5] != 0)
                textViews_25.setText(Game_Soduku.show[2][5] + "");
            if (Game_Soduku.show[2][6] != 0)
                textViews_26.setText(Game_Soduku.show[2][6] + "");
            if (Game_Soduku.show[2][7] != 0)
                textViews_27.setText(Game_Soduku.show[2][7] + "");
            if (Game_Soduku.show[2][8] != 0)
                textViews_28.setText(Game_Soduku.show[2][8] + "");
        }
        {
            if (Game_Soduku.show[3][0] != 0)
                textViews_30.setText(Game_Soduku.show[3][0] + "");
            if (Game_Soduku.show[3][1] != 0)
                textViews_31.setText(Game_Soduku.show[3][1] + "");
            if (Game_Soduku.show[3][2] != 0)
                textViews_32.setText(Game_Soduku.show[3][2] + "");
            if (Game_Soduku.show[3][3] != 0)
                textViews_33.setText(Game_Soduku.show[3][3] + "");
            if (Game_Soduku.show[3][4] != 0)
                textViews_34.setText(Game_Soduku.show[3][4] + "");
            if (Game_Soduku.show[3][5] != 0)
                textViews_35.setText(Game_Soduku.show[3][5] + "");
            if (Game_Soduku.show[3][6] != 0)
                textViews_36.setText(Game_Soduku.show[3][6] + "");
            if (Game_Soduku.show[3][7] != 0)
                textViews_37.setText(Game_Soduku.show[3][7] + "");
            if (Game_Soduku.show[3][8] != 0)
                textViews_38.setText(Game_Soduku.show[3][8] + "");
        }
        {
            if (Game_Soduku.show[4][0] != 0)
                textViews_40.setText(Game_Soduku.show[4][0] + "");
            if (Game_Soduku.show[4][1] != 0)
                textViews_41.setText(Game_Soduku.show[4][1] + "");
            if (Game_Soduku.show[4][2] != 0)
                textViews_42.setText(Game_Soduku.show[4][2] + "");
            if (Game_Soduku.show[4][3] != 0)
                textViews_43.setText(Game_Soduku.show[4][3] + "");
            if (Game_Soduku.show[4][4] != 0)
                textViews_44.setText(Game_Soduku.show[4][4] + "");
            if (Game_Soduku.show[4][5] != 0)
                textViews_45.setText(Game_Soduku.show[4][5] + "");
            if (Game_Soduku.show[4][6] != 0)
                textViews_46.setText(Game_Soduku.show[4][6] + "");
            if (Game_Soduku.show[4][7] != 0)
                textViews_47.setText(Game_Soduku.show[4][7] + "");
            if (Game_Soduku.show[4][8] != 0)
                textViews_48.setText(Game_Soduku.show[4][8] + "");
        }
        {
            if (Game_Soduku.show[5][0] != 0)
                textViews_50.setText(Game_Soduku.show[5][0] + "");
            if (Game_Soduku.show[5][1] != 0)
                textViews_51.setText(Game_Soduku.show[5][1] + "");
            if (Game_Soduku.show[5][2] != 0)
                textViews_52.setText(Game_Soduku.show[5][2] + "");
            if (Game_Soduku.show[5][3] != 0)
                textViews_53.setText(Game_Soduku.show[5][3] + "");
            if (Game_Soduku.show[5][4] != 0)
                textViews_54.setText(Game_Soduku.show[5][4] + "");
            if (Game_Soduku.show[5][5] != 0)
                textViews_55.setText(Game_Soduku.show[5][5] + "");
            if (Game_Soduku.show[5][6] != 0)
                textViews_56.setText(Game_Soduku.show[5][6] + "");
            if (Game_Soduku.show[5][7] != 0)
                textViews_57.setText(Game_Soduku.show[5][7] + "");
            if (Game_Soduku.show[5][8] != 0)
                textViews_58.setText(Game_Soduku.show[5][8] + "");
        }
        {
            if (Game_Soduku.show[6][0] != 0)
                textViews_60.setText(Game_Soduku.show[6][0] + "");
            if (Game_Soduku.show[6][1] != 0)
                textViews_61.setText(Game_Soduku.show[6][1] + "");
            if (Game_Soduku.show[6][2] != 0)
                textViews_62.setText(Game_Soduku.show[6][2] + "");
            if (Game_Soduku.show[6][3] != 0)
                textViews_63.setText(Game_Soduku.show[6][3] + "");
            if (Game_Soduku.show[6][4] != 0)
                textViews_64.setText(Game_Soduku.show[6][4] + "");
            if (Game_Soduku.show[6][5] != 0)
                textViews_65.setText(Game_Soduku.show[6][5] + "");
            if (Game_Soduku.show[6][6] != 0)
                textViews_66.setText(Game_Soduku.show[6][6] + "");
            if (Game_Soduku.show[6][7] != 0)
                textViews_67.setText(Game_Soduku.show[6][7] + "");
            if (Game_Soduku.show[6][8] != 0)
                textViews_68.setText(Game_Soduku.show[6][8] + "");
        }
        {
            if (Game_Soduku.show[7][0] != 0)
                textViews_70.setText(Game_Soduku.show[7][0] + "");
            if (Game_Soduku.show[7][1] != 0)
                textViews_71.setText(Game_Soduku.show[7][1] + "");
            if (Game_Soduku.show[7][2] != 0)
                textViews_72.setText(Game_Soduku.show[7][2] + "");
            if (Game_Soduku.show[7][3] != 0)
                textViews_73.setText(Game_Soduku.show[7][3] + "");
            if (Game_Soduku.show[7][4] != 0)
                textViews_74.setText(Game_Soduku.show[7][4] + "");
            if (Game_Soduku.show[7][5] != 0)
                textViews_75.setText(Game_Soduku.show[7][5] + "");
            if (Game_Soduku.show[7][6] != 0)
                textViews_76.setText(Game_Soduku.show[7][6] + "");
            if (Game_Soduku.show[7][7] != 0)
                textViews_77.setText(Game_Soduku.show[7][7] + "");
            if (Game_Soduku.show[7][8] != 0)
                textViews_78.setText(Game_Soduku.show[7][8] + "");
        }
        {
            if (Game_Soduku.show[8][0] != 0)
                textViews_80.setText(Game_Soduku.show[8][0] + "");
            if (Game_Soduku.show[8][1] != 0)
                textViews_81.setText(Game_Soduku.show[8][1] + "");
            if (Game_Soduku.show[8][2] != 0)
                textViews_82.setText(Game_Soduku.show[8][2] + "");
            if (Game_Soduku.show[8][3] != 0)
                textViews_83.setText(Game_Soduku.show[8][3] + "");
            if (Game_Soduku.show[8][4] != 0)
                textViews_84.setText(Game_Soduku.show[8][4] + "");
            if (Game_Soduku.show[8][5] != 0)
                textViews_85.setText(Game_Soduku.show[8][5] + "");
            if (Game_Soduku.show[8][6] != 0)
                textViews_86.setText(Game_Soduku.show[8][6] + "");
            if (Game_Soduku.show[8][7] != 0)
                textViews_87.setText(Game_Soduku.show[8][7] + "");
            if (Game_Soduku.show[8][8] != 0)
                textViews_88.setText(Game_Soduku.show[8][8] + "");
        }

    }

    private void chon_so(TextView tt){
        buttons_so_1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                tt.setText("1");
                tt.setTextColor(R.color.sudoku_show);
                update();checked();
            }
        });
        buttons_so_2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                tt.setText("2");
                tt.setTextColor(R.color.sudoku_show);
                update();checked();
            }
        });
        buttons_so_3.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                tt.setText("3");
                tt.setTextColor(R.color.sudoku_show);
                update();checked();
            }
        });
        buttons_so_4.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                tt.setText("4");
                tt.setTextColor(R.color.sudoku_show);
                update();checked();
            }
        });
        buttons_so_5.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                tt.setText("5");
                tt.setTextColor(R.color.sudoku_show);
                update();checked();
            }
        });
        buttons_so_6.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                tt.setText("6");
                tt.setTextColor(R.color.sudoku_show);
                update();checked();
            }
        });
        buttons_so_7.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                tt.setText("7");
                tt.setTextColor(R.color.sudoku_show);
                update();checked();
            }
        });
        buttons_so_8.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                tt.setText("8");
                tt.setTextColor(R.color.sudoku_show);
                update();checked();
            }
        });
        buttons_so_9.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                tt.setText("9");
                tt.setTextColor(R.color.sudoku_show);
                update();checked();
            }
        });
    }

    private void xoaso(TextView tt){
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tt.setText("");
                update();
                checked();
            }
        });
    }

    private void khoitao_id(){

        save=findViewById(R.id.sudoku_save);
        exit=findViewById(R.id.sudoku_exit);
        delete=findViewById(R.id.sudoku_xoa);
        goiy=findViewById(R.id.sudoku_goi_y);

        buttons_so_1 = findViewById(R.id.sudoku_1);
        buttons_so_2 = findViewById(R.id.sudoku_2);
        buttons_so_4 = findViewById(R.id.sudoku_4);
        buttons_so_3 = findViewById(R.id.sudoku_3);
        buttons_so_5 = findViewById(R.id.sudoku_5);
        buttons_so_6 = findViewById(R.id.sudoku_6);
        buttons_so_7 = findViewById(R.id.sudoku_7);
        buttons_so_8 = findViewById(R.id.sudoku_8);
        buttons_so_9 = findViewById(R.id.sudoku_9);


            //hàng 1
        textViews_00 = findViewById(R.id.sudoku_00);
        textViews_01 = findViewById(R.id.sudoku_01);
        textViews_02 = findViewById(R.id.sudoku_02);
        textViews_03 = findViewById(R.id.sudoku_03);
        textViews_04 = findViewById(R.id.sudoku_04);
        textViews_05 = findViewById(R.id.sudoku_05);
        textViews_06 = findViewById(R.id.sudoku_06);
        textViews_07 = findViewById(R.id.sudoku_07);
        textViews_08 = findViewById(R.id.sudoku_08);

        //hàng 2
        textViews_10 = findViewById(R.id.sudoku_10);
        textViews_11 = findViewById(R.id.sudoku_11);
        textViews_12 = findViewById(R.id.sudoku_12);
        textViews_13 = findViewById(R.id.sudoku_13);
        textViews_14 = findViewById(R.id.sudoku_14);
        textViews_15 = findViewById(R.id.sudoku_15);
        textViews_16 = findViewById(R.id.sudoku_16);
        textViews_17 = findViewById(R.id.sudoku_17);
        textViews_18 = findViewById(R.id.sudoku_18);
        //hàng 3
        textViews_20 = findViewById(R.id.sudoku_20);
        textViews_21 = findViewById(R.id.sudoku_21);
        textViews_22 = findViewById(R.id.sudoku_22);
        textViews_23 = findViewById(R.id.sudoku_23);
        textViews_24 = findViewById(R.id.sudoku_24);
        textViews_25 = findViewById(R.id.sudoku_25);
        textViews_26 = findViewById(R.id.sudoku_26);
        textViews_27 = findViewById(R.id.sudoku_27);
        textViews_28 = findViewById(R.id.sudoku_28);
        //hàng 4
        textViews_30 = findViewById(R.id.sudoku_30);
        textViews_31 = findViewById(R.id.sudoku_31);
        textViews_32 = findViewById(R.id.sudoku_32);
        textViews_33 = findViewById(R.id.sudoku_33);
        textViews_34 = findViewById(R.id.sudoku_34);
        textViews_35 = findViewById(R.id.sudoku_35);
        textViews_36 = findViewById(R.id.sudoku_36);
        textViews_37 = findViewById(R.id.sudoku_37);
        textViews_38 = findViewById(R.id.sudoku_38);
        //hàng 5
        textViews_40 = findViewById(R.id.sudoku_40);
        textViews_41 = findViewById(R.id.sudoku_41);
        textViews_42 = findViewById(R.id.sudoku_42);
        textViews_43 = findViewById(R.id.sudoku_43);
        textViews_44 = findViewById(R.id.sudoku_44);
        textViews_45 = findViewById(R.id.sudoku_45);
        textViews_46 = findViewById(R.id.sudoku_46);
        textViews_47 = findViewById(R.id.sudoku_47);
        textViews_48 = findViewById(R.id.sudoku_48);
        //hàng 6
        textViews_50 = findViewById(R.id.sudoku_50);
        textViews_51 = findViewById(R.id.sudoku_51);
        textViews_52 = findViewById(R.id.sudoku_52);
        textViews_53 = findViewById(R.id.sudoku_53);
        textViews_54 = findViewById(R.id.sudoku_54);
        textViews_55 = findViewById(R.id.sudoku_55);
        textViews_56 = findViewById(R.id.sudoku_56);
        textViews_57 = findViewById(R.id.sudoku_57);
        textViews_58 = findViewById(R.id.sudoku_58);
        //hàng 7
        textViews_60 = findViewById(R.id.sudoku_60);
        textViews_61 = findViewById(R.id.sudoku_61);
        textViews_62 = findViewById(R.id.sudoku_62);
        textViews_63 = findViewById(R.id.sudoku_63);
        textViews_64 = findViewById(R.id.sudoku_64);
        textViews_65 = findViewById(R.id.sudoku_65);
        textViews_66 = findViewById(R.id.sudoku_66);
        textViews_67 = findViewById(R.id.sudoku_67);
        textViews_68 = findViewById(R.id.sudoku_68);
        //hàng 8
        textViews_70 = findViewById(R.id.sudoku_70);
        textViews_71 = findViewById(R.id.sudoku_71);
        textViews_72 = findViewById(R.id.sudoku_72);
        textViews_73 = findViewById(R.id.sudoku_73);
        textViews_74 = findViewById(R.id.sudoku_74);
        textViews_75 = findViewById(R.id.sudoku_75);
        textViews_76 = findViewById(R.id.sudoku_76);
        textViews_77 = findViewById(R.id.sudoku_77);
        textViews_78 = findViewById(R.id.sudoku_78);
        //hàng 9
        textViews_80 = findViewById(R.id.sudoku_80);
        textViews_81 = findViewById(R.id.sudoku_81);
        textViews_82 = findViewById(R.id.sudoku_82);
        textViews_83 = findViewById(R.id.sudoku_83);
        textViews_84 = findViewById(R.id.sudoku_84);
        textViews_85 = findViewById(R.id.sudoku_85);
        textViews_86 = findViewById(R.id.sudoku_86);
        textViews_87 = findViewById(R.id.sudoku_87);
        textViews_88 = findViewById(R.id.sudoku_88);
    }

    @SuppressLint("ResourceAsColor")
    private void shownull(){
        textViews_00.setBackground(null);
        textViews_01.setBackground(null);
        textViews_02.setBackground(null);
        textViews_03.setBackground(null);
        textViews_04.setBackground(null);
        textViews_05.setBackground(null);
        textViews_06.setBackground(null);
        textViews_07.setBackground(null);
        textViews_08.setBackground(null);
        //hàng 2
        textViews_10.setBackground(null);
        textViews_11.setBackground(null);
        textViews_12.setBackground(null);
        textViews_13.setBackground(null);
        textViews_14.setBackground(null);
        textViews_15.setBackground(null);
        textViews_16.setBackground(null);
        textViews_17.setBackground(null);
        textViews_18.setBackground(null);
        //hàng 3
        textViews_20.setBackground(null);
        textViews_21.setBackground(null);
        textViews_22.setBackground(null);
        textViews_23.setBackground(null);
        textViews_24.setBackground(null);
        textViews_25.setBackground(null);
        textViews_26.setBackground(null);
        textViews_27.setBackground(null);
        textViews_28.setBackground(null);
        //hàng 4
        textViews_30.setBackground(null);
        textViews_31.setBackground(null);
        textViews_32.setBackground(null);
        textViews_33.setBackground(null);
        textViews_34.setBackground(null);
        textViews_35.setBackground(null);
        textViews_36.setBackground(null);
        textViews_37.setBackground(null);
        textViews_38.setBackground(null);
        //hàng 5
        textViews_40.setBackground(null);
        textViews_41.setBackground(null);
        textViews_42.setBackground(null);
        textViews_43.setBackground(null);
        textViews_44.setBackground(null);
        textViews_45.setBackground(null);
        textViews_46.setBackground(null);
        textViews_47.setBackground(null);
        textViews_48.setBackground(null);
        //hàng 6
        textViews_50.setBackground(null);
        textViews_51.setBackground(null);
        textViews_52.setBackground(null);
        textViews_53.setBackground(null);
        textViews_54.setBackground(null);
        textViews_55.setBackground(null);
        textViews_56.setBackground(null);
        textViews_57.setBackground(null);
        textViews_58.setBackground(null);
        //hàng 7
        textViews_60.setBackground(null);
        textViews_61.setBackground(null);
        textViews_62.setBackground(null);
        textViews_63.setBackground(null);
        textViews_64.setBackground(null);
        textViews_65.setBackground(null);
        textViews_66.setBackground(null);
        textViews_67.setBackground(null);
        textViews_68.setBackground(null);
        //hàng 8
        textViews_70.setBackground(null);
        textViews_71.setBackground(null);
        textViews_72.setBackground(null);
        textViews_73.setBackground(null);
        textViews_74.setBackground(null);
        textViews_75.setBackground(null);
        textViews_76.setBackground(null);
        textViews_77.setBackground(null);
        textViews_78.setBackground(null);
        //hàng 9
        textViews_80.setBackground(null);
        textViews_81.setBackground(null);
        textViews_82.setBackground(null);
        textViews_83.setBackground(null);
        textViews_84.setBackground(null);
        textViews_85.setBackground(null);
        textViews_86.setBackground(null);
        textViews_87.setBackground(null);
        textViews_88.setBackground(null);
    }

}