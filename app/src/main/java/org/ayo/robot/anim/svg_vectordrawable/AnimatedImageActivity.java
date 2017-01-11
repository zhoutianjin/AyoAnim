package org.ayo.robot.anim.svg_vectordrawable;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import org.ayo.robot.anim.App;
import org.ayo.robot.anim.R;
import org.ayo.sample.menu.attacher.ActivityAttacher;
import org.ayo.sample.menu.notify.Toaster;

public abstract class AnimatedImageActivity extends ActivityAttacher {
  private ImageView imageView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(getLayoutId());
    imageView = (ImageView) findViewById(R.id.image);
    imageView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        animate();
      }
    });
  }

  private void animate() {
    if(!App.supportMaterial()){
      Toaster.toastShort("系统版本低于5.0，不支持AnimatedVectorDrawable");
      return;
    }
    Drawable drawable = imageView.getDrawable();
    if (drawable instanceof Animatable) {
      ((Animatable) drawable).start();
    }
  }

  protected abstract int getLayoutId();
}