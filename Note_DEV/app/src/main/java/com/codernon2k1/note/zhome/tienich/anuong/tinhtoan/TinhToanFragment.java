package com.codernon2k1.note.zhome.tienich.anuong.tinhtoan;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.codernon2k1.note.databinding.FragmentTinhToanBinding;

public class TinhToanFragment extends Fragment {

    public static FragmentTinhToanBinding binding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTinhToanBinding.inflate(inflater, container, false);

        binding.tinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String can = binding.cannang.getText().toString();
                String cao =binding.chieucao.getText().toString();
                if (can.equals("")){
                    Toast.makeText(binding.getRoot().getContext(),"Cân nặng không thể bỏ trống",Toast.LENGTH_LONG).show();
                }
                else
                if (cao.equals("")){
                    Toast.makeText(binding.getRoot().getContext(),"Chieu cao không thể bỏ trống",Toast.LENGTH_LONG).show();
                }
                else{
                    int kg = chuyen_so(can);
                    double met = (double)chuyen_so(cao)/100;
                    double kp = (double)kg / (met*met);
                    binding.chiso.setText(String.format("Chỉ số BMI la %.2f", kp) );
                    if (kp < 18.5){
                        binding.khuyen.setText("Bạn quá gầy , bạn cần ăn uống đầy đủ và dinh dưỡng 1 cách hợp lý");
                    }
                    else if (kp < 25){
                        binding.khuyen.setText("Bạn có chỉ số binh thường , bạn nên duy trì");
                    }
                    else if (kp < 30){
                        binding.khuyen.setText("Bạn đang thừ cân , bạn cần có chế đồ ăn uống và rèn luyện sức khỏe hợp lý");
                    }
                    else{
                        binding.khuyen.setText("Bạn dang mắc béo phì !!!! ");
                    }
                }

            }
        });


        return binding.getRoot();
    }

    public static int chuyen_so(String str){
        int t=0;
        for (int i=0;i<str.length();i++){
            t=t*10 + (str.charAt(i) - '0');
        }
        return t;
    }


}