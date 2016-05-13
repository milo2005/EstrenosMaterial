package movil.estrenos.attrs;

import android.content.res.AssetManager;
import android.databinding.BindingAdapter;
import android.graphics.Typeface;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Created by Dario Chamorro on 11/05/2016.
 */
public class Attrs {

    static SimpleDateFormat format =
            new SimpleDateFormat("yyyy/MM/dd");

    @BindingAdapter("app:imgUrl")
    public static void loadImg(ImageView img, String url){
        Picasso.with(img.getContext())
                .load(Uri.parse(url))
                .into(img);
    }

    @BindingAdapter("app:textDate")
    public static void loadDate(TextView txt, Date date){
        txt.setText(format.format(date));
    }

    @BindingAdapter("app:customFamily")
    public static void loadFont(TextView txt, String family){
        AssetManager manager = txt.getContext().getAssets();
        Typeface typeface = Typeface
                .createFromAsset(manager, "fonts/"+family);
        txt.setTypeface(typeface);
    }

}
