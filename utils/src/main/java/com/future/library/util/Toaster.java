package com.future.library.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.StringRes;
import android.widget.Toast;

/**
 * Class description:
 *
 * @author zp
 * @version 1.0
 * @see Toaster
 * @since 2017/5/4
 */
public class Toaster {
    private Toaster() {
        throw new UnsupportedOperationException("Can not invoke Constructor!");
    }

    /**
     * 显示文本的Toast
     */
    private static volatile Toast sTextToast;

    /**
     * 初始化工具类
     *
     * @param context application的Context，Toast的上下文与Activity无关
     */
    @SuppressLint("ShowToast")
    public static void initialize(Context context) {
        if (sTextToast == null) {
            synchronized (Toaster.class) {
                if (sTextToast == null) {
                    sTextToast = Toast.makeText(context, "", Toast.LENGTH_SHORT);
                }
            }
        }
    }

    /**
     * 取消Toast显示
     */
    public static void cancel() {
        Preconditions.checkNotNull(sTextToast, "Toaster must initialize before use.");
        sTextToast.cancel();
    }

    /**
     * 显示提示消息
     *
     * @param message  提示文本
     * @param duration 提示时长
     * @param margins  margins
     * @param gravity  显示位置
     */
    public static void showToast(CharSequence message, int duration, Margins margins, Gravity gravity) {
        Preconditions.checkNotNull(sTextToast, "Toaster must initialize before use.");
        sTextToast.setText(message);
        sTextToast.setDuration(duration);
        if (margins != null) {
            sTextToast.setMargin(margins.horizontalMargin, margins.verticalMargin);
        }
        if (gravity != null) {
            sTextToast.setGravity(gravity.gravity, gravity.xOffset, gravity.yOffset);
        }
        sTextToast.show();
    }

    /**
     * 显示提示消息
     *
     * @param message  提示文本
     * @param duration 提示时长
     */
    public static void showToast(CharSequence message, int duration) {
        Preconditions.checkNotNull(sTextToast, "Toaster must initialize before use.");
        sTextToast.setText(message);
        sTextToast.setDuration(duration);
        sTextToast.show();
    }

    /**
     * 显示提示消息
     *
     * @param message 提示文本
     */
    public static void showToast(CharSequence message) {
        showToast(message, Toast.LENGTH_SHORT);
    }

    /**
     * 显示提示消息
     *
     * @param resId    提示文本资源id
     * @param duration 提示时长
     * @param margins  margins
     * @param gravity  显示位置
     */
    public static void showToast(@StringRes int resId, int duration, Margins margins, Gravity gravity) {
        Context context = sTextToast.getView().getContext().getApplicationContext();
        showToast(context.getResources().getText(resId), duration, margins, gravity);
    }

    /**
     * 显示提示消息
     *
     * @param resId    提示文本资源id
     * @param duration 提示时长
     */
    public static void showToast(@StringRes int resId, int duration) {
        Context context = sTextToast.getView().getContext().getApplicationContext();
        showToast(context.getResources().getText(resId), duration);
    }

    /**
     * 显示提示消息
     *
     * @param resId 提示文本资源id
     */
    public static void showToast(@StringRes int resId) {
        showToast(resId, Toast.LENGTH_SHORT);
    }

    public static class Margins {
        public float horizontalMargin;
        public float verticalMargin;
    }

    public static class Gravity {
        public int gravity;
        public int xOffset;
        public int yOffset;
    }
}
