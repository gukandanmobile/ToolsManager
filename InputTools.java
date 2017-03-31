package com.visoport.medicine.util;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by John on 2017/3/31.
 * 键盘工具类
 */

public class InputTools {
    /**
     * 隐藏键盘
     *
     * @param v
     */
    public static void HideKeyboard(View v) {
        InputMethodManager inputMethodManager = (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (inputMethodManager.isActive()) {
            inputMethodManager.hideSoftInputFromWindow(v.getApplicationWindowToken(), 0);

        }

    }

    /**
     * 显示键盘
     *
     * @param v
     */
    public static void ShowKeyboard(View v) {
        InputMethodManager inputMethodManager = (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.showSoftInput(v, InputMethodManager.SHOW_FORCED);
    }

    /**
     * 强制显示或者关闭系统键盘
     *
     * @param txtSearchKey 键盘的key
     * @param status       键盘的状态
     */

    public static void KeyBoard(final EditText txtSearchKey, final String status) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                InputMethodManager im = (InputMethodManager) txtSearchKey.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                if (status.equals("open")) {
                    im.showSoftInput(txtSearchKey, InputMethodManager.SHOW_FORCED);
                } else {
                    im.hideSoftInputFromWindow(txtSearchKey.getWindowToken(), 0);
                }

            }
        }, 400);
    }

    /**
     * 通过定时器强制隐藏虚拟键盘
     *
     * @param v
     */
    public static void TimerHideKeyboard(final View v) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                InputMethodManager imm = (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm.isActive()) {
                    imm.hideSoftInputFromWindow(v.getApplicationWindowToken(), 0);
                }

            }
        }, 10);
    }

    /**
     * 判断输入是否显示
     * @param editText
     * @return
     */
    public static boolean Keyboard(EditText editText) {
        boolean flag = false;
        InputMethodManager imm = (InputMethodManager) editText.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm.isActive()) {
            flag = true;
        }
        return flag;
    }
    /**
     * 打卡软键盘
     *
     * @param mEditText 输入框
     * @param mContext  上下文
     */
    public static void openKeybord(Context mContext, EditText mEditText) {
        InputMethodManager imm = (InputMethodManager) mContext
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(mEditText, InputMethodManager.RESULT_SHOWN);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,
                InputMethodManager.HIDE_IMPLICIT_ONLY);
    }

    /**
     * 关闭软键盘
     *
     * @param mEditText 输入框
     * @param mContext  上下文
     */
    public static void closeKeybord(Context mContext, EditText mEditText) {
        InputMethodManager imm = (InputMethodManager) mContext
                .getSystemService(Context.INPUT_METHOD_SERVICE);

        imm.hideSoftInputFromWindow(mEditText.getWindowToken(), 0);
    }

}
