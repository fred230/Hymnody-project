package com.fredrick.hymnal_ultimate;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.media.MediaPlayer;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class LyricsActivity<intent> extends AppCompatActivity {

    TextView textView, title;
    Intent intent;
    private AudioManager audio;
    private ClipboardManager clipboardManager;
    public String copy_data;
     MediaPlayer mp;




    int[] mid_files = {R.raw.song001, R.raw.song002, R.raw.song003,
            R.raw.song004, R.raw.song005, R.raw.song006,
            R.raw.song007, R.raw.song008, R.raw.song009,
            R.raw.song010, R.raw.song011, R.raw.song012,
            R.raw.song013, R.raw.song014, R.raw.song015,
            R.raw.song016, R.raw.song017, R.raw.song018,
            R.raw.song019, R.raw.song020,
            R.raw.song021, R.raw.song022, R.raw.song023
            , R.raw.song024, R.raw.song025, R.raw.song026,
            R.raw.song027, R.raw.song028, R.raw.song029,
            R.raw.song030, R.raw.song031, R.raw.song032,
            R.raw.song033, R.raw.song034, R.raw.song035,
            R.raw.song036, R.raw.song037, R.raw.song038,
            R.raw.song039,
            R.raw.song040, R.raw.song041, R.raw.song042, R.raw.song043,
            R.raw.song044, R.raw.song045, R.raw.song046, R.raw.song047,
            R.raw.song048, R.raw.song049, R.raw.song050, R.raw.song051,
            R.raw.song052, R.raw.song053, R.raw.song054, R.raw.song055,
            R.raw.song056, R.raw.song057, R.raw.song058, R.raw.song059,
            R.raw.song060, R.raw.song061, R.raw.song062, R.raw.song063,
            R.raw.song064, R.raw.song065, R.raw.song066, R.raw.song067,
            R.raw.song068, R.raw.song069, R.raw.song070, R.raw.song071,
            R.raw.song072, R.raw.song073, R.raw.song074, R.raw.song075,
            R.raw.song076, R.raw.song077, R.raw.song078, R.raw.song079,
            R.raw.song080, R.raw.song081, R.raw.song082, R.raw.song083,
            R.raw.song084, R.raw.song085, R.raw.song086, R.raw.song087,
            R.raw.song088, R.raw.song089, R.raw.song090, R.raw.song091,
            R.raw.song092, R.raw.song093, R.raw.song094, R.raw.song095,
            R.raw.song096, R.raw.song097, R.raw.song098, R.raw.song099,
            R.raw.song100, R.raw.song101, R.raw.song102, R.raw.song103, R.raw.song104, R.raw.song105, R.raw.song106, R.raw.song107, R.raw.song108, R.raw.song109, R.raw.song110, R.raw.song111, R.raw.song112, R.raw.song113, R.raw.song114, R.raw.song115, R.raw.song116, R.raw.song117, R.raw.song118, R.raw.song119, R.raw.song120, R.raw.song121, R.raw.song122, R.raw.song123, R.raw.song124, R.raw.song125, R.raw.song126, R.raw.song127, R.raw.song128, R.raw.song129, R.raw.song130, R.raw.song131, R.raw.song132, R.raw.song133, R.raw.song134, R.raw.song135, R.raw.song136, R.raw.song137, R.raw.song138, R.raw.song139, R.raw.song140, R.raw.song141, R.raw.song142,
            R.raw.song143, R.raw.song144, R.raw.song145, R.raw.song146, R.raw.song147, R.raw.song148, R.raw.song149, R.raw.song150, R.raw.song151, R.raw.song152, R.raw.song153, R.raw.song154, R.raw.song155, R.raw.song156, R.raw.song157, R.raw.song158, R.raw.song159, R.raw.song160, R.raw.song161, R.raw.song162, R.raw.song163,
            R.raw.song164, R.raw.song165, R.raw.song166, R.raw.song167, R.raw.song168, R.raw.song169, R.raw.song170, R.raw.song171, R.raw.song172, R.raw.song173, R.raw.song174, R.raw.song175, R.raw.song176, R.raw.song177, R.raw.song178, R.raw.song179, R.raw.song180, R.raw.song181, R.raw.song182, R.raw.song183, R.raw.song184, R.raw.song185, R.raw.song186, R.raw.song187, R.raw.song188, R.raw.song189, R.raw.song190, R.raw.song191, R.raw.song192, R.raw.song193, R.raw.song194, R.raw.song195, R.raw.song196, R.raw.song197, R.raw.song198, R.raw.song199, R.raw.song200, R.raw.song201, R.raw.song202, R.raw.song203, R.raw.song204, R.raw.song205, R.raw.song206, R.raw.song207, R.raw.song208, R.raw.song209, R.raw.song210, R.raw.song211, R.raw.song212, R.raw.song213, R.raw.song214, R.raw.song215, R.raw.song216, R.raw.song217, R.raw.song218, R.raw.song219, R.raw.song220, R.raw.song221, R.raw.song222, R.raw.song223, R.raw.song224, R.raw.song225, R.raw.song226, R.raw.song227, R.raw.song228, R.raw.song229, R.raw.song230, R.raw.song231, R.raw.song232, R.raw.song233, R.raw.song234, R.raw.song235, R.raw.song236, R.raw.song237, R.raw.song238, R.raw.song239, R.raw.song240, R.raw.song241, R.raw.song242, R.raw.song243,
            R.raw.song244, R.raw.song245, R.raw.song246, R.raw.song247, R.raw.song248, R.raw.song249, R.raw.song250, R.raw.song251, R.raw.song252, R.raw.song253, R.raw.song254, R.raw.song255, R.raw.song256, R.raw.song257, R.raw.song258, R.raw.song259, R.raw.song260, R.raw.song261, R.raw.song262, R.raw.song263, R.raw.song264, R.raw.song265, R.raw.song266, R.raw.song267, R.raw.song268, R.raw.song269, R.raw.song270, R.raw.song271, R.raw.song272, R.raw.song273, R.raw.song274, R.raw.song275, R.raw.song276, R.raw.song277, R.raw.song278, R.raw.song279, R.raw.song280, R.raw.song281, R.raw.song282, R.raw.song283, R.raw.song284, R.raw.song285, R.raw.song286, R.raw.song287, R.raw.song288, R.raw.song289, R.raw.song290, R.raw.song291, R.raw.song292, R.raw.song293, R.raw.song294, R.raw.song295, R.raw.song296, R.raw.song297, R.raw.song298, R.raw.song299, R.raw.song300, R.raw.song301, R.raw.song302, R.raw.song303, R.raw.song304, R.raw.song305, R.raw.song306, R.raw.song307, R.raw.song308, R.raw.song309, R.raw.song310, R.raw.song311, R.raw.song312, R.raw.song313, R.raw.song314, R.raw.song315, R.raw.song316, R.raw.song317, R.raw.song318, R.raw.song319, R.raw.song320, R.raw.song321, R.raw.song322, R.raw.song323, R.raw.song324, R.raw.song325, R.raw.song326, R.raw.song327, R.raw.song328, R.raw.song329, R.raw.song330, R.raw.song331, R.raw.song332, R.raw.song333, R.raw.song334, R.raw.song335, R.raw.song336, R.raw.song337, R.raw.song338, R.raw.song339, R.raw.song340, R.raw.song341,
            R.raw.song342, R.raw.song343, R.raw.song344, R.raw.song345, R.raw.song346, R.raw.song347, R.raw.song348, R.raw.song349, R.raw.song350, R.raw.song351, R.raw.song352, R.raw.song353, R.raw.song354, R.raw.song355, R.raw.song356, R.raw.song357, R.raw.song358, R.raw.song359, R.raw.song360, R.raw.song361, R.raw.song362, R.raw.song363, R.raw.song364, R.raw.song365, R.raw.song366, R.raw.song367, R.raw.song368, R.raw.song369, R.raw.song370, R.raw.song371, R.raw.song372, R.raw.song373, R.raw.song374, R.raw.song375, R.raw.song376, R.raw.song377, R.raw.song378, R.raw.song379, R.raw.song380, R.raw.song381, R.raw.song382, R.raw.song383, R.raw.song384, R.raw.song385, R.raw.song386, R.raw.song387, R.raw.song388, R.raw.song389, R.raw.song390, R.raw.song391, R.raw.song392, R.raw.song393, R.raw.song394, R.raw.song395, R.raw.song396, R.raw.song397, R.raw.song398, R.raw.song399, R.raw.song400, R.raw.song401, R.raw.song402, R.raw.song403, R.raw.song404, R.raw.song405, R.raw.song406, R.raw.song407, R.raw.song408, R.raw.song409, R.raw.song410, R.raw.song411, R.raw.song412, R.raw.song413, R.raw.song414, R.raw.song415, R.raw.song416, R.raw.song417, R.raw.song418, R.raw.song419, R.raw.song420, R.raw.song421, R.raw.song422, R.raw.song423, R.raw.song424, R.raw.song425, R.raw.song426, R.raw.song427, R.raw.song428, R.raw.song429, R.raw.song430, R.raw.song431, R.raw.song432, R.raw.song433, R.raw.song434, R.raw.song435, R.raw.song436, R.raw.song437, R.raw.song438, R.raw.song439,
            R.raw.song440, R.raw.song441, R.raw.song442, R.raw.song443, R.raw.song444, R.raw.song445, R.raw.song446, R.raw.song447, R.raw.song448, R.raw.song449, R.raw.song450, R.raw.song451, R.raw.song452, R.raw.song453, R.raw.song454, R.raw.song455, R.raw.song456, R.raw.song457, R.raw.song458, R.raw.song459, R.raw.song460, R.raw.song461, R.raw.song462, R.raw.song463, R.raw.song464, R.raw.song465, R.raw.song466, R.raw.song467, R.raw.song468, R.raw.song469, R.raw.song470, R.raw.song471, R.raw.song472, R.raw.song473, R.raw.song474, R.raw.song475, R.raw.song476, R.raw.song477, R.raw.song478, R.raw.song479, R.raw.song480, R.raw.song481, R.raw.song482, R.raw.song483, R.raw.song484, R.raw.song485, R.raw.song486, R.raw.song487, R.raw.song488, R.raw.song489, R.raw.song490, R.raw.song491, R.raw.song492, R.raw.song493, R.raw.song494, R.raw.song495, R.raw.song496, R.raw.song497, R.raw.song498, R.raw.song499, R.raw.song500, R.raw.song501, R.raw.song502, R.raw.song503, R.raw.song504, R.raw.song505, R.raw.song506, R.raw.song507, R.raw.song508, R.raw.song509, R.raw.song510, R.raw.song511, R.raw.song512, R.raw.song513, R.raw.song514, R.raw.song515, R.raw.song516, R.raw.song517, R.raw.song518, R.raw.song519, R.raw.song520, R.raw.song521, R.raw.song522, R.raw.song523, R.raw.song524, R.raw.song525, R.raw.song526, R.raw.song527, R.raw.song528, R.raw.song529, R.raw.song530, R.raw.song531, R.raw.song532, R.raw.song533, R.raw.song534, R.raw.song535, R.raw.song536, R.raw.song537,
            R.raw.song538, R.raw.song539, R.raw.song540, R.raw.song541, R.raw.song542, R.raw.song543, R.raw.song544, R.raw.song545,
            R.raw.song546, R.raw.song547, R.raw.song548, R.raw.song549, R.raw.song550, R.raw.song551, R.raw.song552, R.raw.song553, R.raw.song554, R.raw.song555, R.raw.song556, R.raw.song557, R.raw.song558, R.raw.song559, R.raw.song560, R.raw.song561, R.raw.song562, R.raw.song563, R.raw.song564, R.raw.song565, R.raw.song566, R.raw.song567, R.raw.song568, R.raw.song569, R.raw.song570, R.raw.song571, R.raw.song572, R.raw.song573, R.raw.song574, R.raw.song575, R.raw.song576, R.raw.song577, R.raw.song578, R.raw.song579, R.raw.song580, R.raw.song581, R.raw.song582, R.raw.song583, R.raw.song584, R.raw.song585, R.raw.song586, R.raw.song587, R.raw.song588, R.raw.song589, R.raw.song590, R.raw.song591, R.raw.song592, R.raw.song593, R.raw.song594, R.raw.song595, R.raw.song596, R.raw.song597, R.raw.song598, R.raw.song599, R.raw.song600, R.raw.song601, R.raw.song602, R.raw.song603, R.raw.song604, R.raw.song605, R.raw.song606, R.raw.song607, R.raw.song608, R.raw.song609, R.raw.song610, R.raw.song611, R.raw.song612, R.raw.song613, R.raw.song614, R.raw.song615, R.raw.song616, R.raw.song617, R.raw.song618, R.raw.song619, R.raw.song620, R.raw.song621, R.raw.song622, R.raw.song623, R.raw.song624, R.raw.song625, R.raw.song626, R.raw.song627, R.raw.song628, R.raw.song629, R.raw.song630, R.raw.song631, R.raw.song632, R.raw.song633, R.raw.song634, R.raw.song635, R.raw.song636, R.raw.song637, R.raw.song638, R.raw.song639, R.raw.song640, R.raw.song641, R.raw.song642, R.raw.song643, R.raw.song644,
            R.raw.song645, R.raw.song646, R.raw.song647, R.raw.song648, R.raw.song649, R.raw.song650, R.raw.song651, R.raw.song652, R.raw.song653, R.raw.song654, R.raw.song655, R.raw.song656, R.raw.song657, R.raw.song658, R.raw.song659, R.raw.song660, R.raw.song661, R.raw.song662, R.raw.song663, R.raw.song664, R.raw.song665, R.raw.song666, R.raw.song667, R.raw.song668, R.raw.song669, R.raw.song670, R.raw.song671,
            R.raw.song672, R.raw.song673, R.raw.song674, R.raw.song675, R.raw.song676, R.raw.song677, R.raw.song678, R.raw.song679, R.raw.song680, R.raw.song681, R.raw.song682, R.raw.song683, R.raw.song684, R.raw.song685, R.raw.song686, R.raw.song687, R.raw.song688, R.raw.song689, R.raw.song690, R.raw.song691, R.raw.song692, R.raw.song693, R.raw.song694, R.raw.song695};






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lyrics);


        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        audio = (AudioManager) getSystemService(Context.AUDIO_SERVICE);


    intent = getIntent();

        textView= findViewById(R.id.text_id);
        title = findViewById(R.id.title_id);

        textView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(LyricsActivity.this);
                builder.setTitle("Copy Hymn");
                builder.setPositiveButton("copy", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        clipboardManager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);

                        copy_data = textView.getText().toString();

                        android.content.ClipData   clip = android.content.ClipData.newPlainText("copied", copy_data);
                        clipboardManager.setPrimaryClip(clip);

                        Toast.makeText(LyricsActivity.this, "copied", Toast.LENGTH_SHORT).show();


                    }
                });

                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
                return false;
            }

        });


        if (intent!=null){
            String lyricShow = intent.getExtras().getString("lyric");
            textView.setText(lyricShow);

            String titleShow =intent.getExtras().getString("title");
            title.setText(titleShow);

        }



        assert intent != null;
        int mCompleted = intent.getExtras().getInt("midi");

         mp = MediaPlayer.create(this, mid_files[mCompleted]);

        ImageButton button = findViewById(R.id.play);
        button.setBackgroundResource(R.drawable.ic_baseline_play_arrow_24);
        ImageButton button1 = findViewById(R.id.pause);
        ImageButton bookmark = findViewById(R.id.bookmark);
        bookmark.setBackgroundResource(R.drawable.bookmark_2);




            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {



                        if (mp.isPlaying()) {
                            mp.pause();
                            button.setBackgroundResource(R.drawable.ic_baseline_play_arrow_24);
                        } else {

                                    mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
                                    mp.setLooping(true);
                                    mp.start();
                                    button.setBackgroundResource(R.drawable.pause);

                        }

                } });





        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{
                    if (this.isPlaying()) {

                        mp.stop();
                        mp.prepare();
                        button.setBackgroundResource(R.drawable.ic_baseline_play_arrow_24);


                    }
                }catch(Exception we){
                    we.printStackTrace();
                }

            }

            private boolean isPlaying() {
                mp.isPlaying();
                return true;
            }
        });

        bookmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bookmark.setBackgroundResource(R.drawable.bookmark_clicked);
                Toast.makeText(LyricsActivity.this, "Hymn Added to Boomarks", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(LyricsActivity.this,BookMark.class);

            }
        });






        }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_VOLUME_UP:
                audio.adjustStreamVolume(AudioManager.STREAM_MUSIC,
                        AudioManager.ADJUST_RAISE, AudioManager.FLAG_SHOW_UI);
                return true;
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                audio.adjustStreamVolume(AudioManager.STREAM_MUSIC,
                        AudioManager.ADJUST_LOWER, AudioManager.FLAG_SHOW_UI);
                return true;
            case KeyEvent.KEYCODE_BACK:
                OnBackPressed();

            default:
                return false;
        }




}

    public void OnBackPressed() {
        super.onBackPressed();

        if (mp!=null && mp.isPlaying()) {
            mp.stop();
            mp.release();
        }

    }



    @Override
    public void onDestroy() {
        super.onDestroy();


        finish();


    }

    @Override
    public void onPause() {
        super.onPause();


        finish();
    }

}


