/**
 * 2012 Foxykeep (http://datadroid.foxykeep.com)
 * <p>
 * Licensed under the Beerware License : <br />
 * As long as you retain this notice you can do whatever you want with this stuff. If we meet some
 * day, and you think this stuff is worth it, you can buy me a beer in return
 */

package com.foxykeep.datadroid.requestmanager;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

import com.foxykeep.datadroid.util.ObjectUtils;

import java.util.ArrayList;

/**
 * Class used to store your request information : request type as well as parameters.
 *
 * @author Foxykeep
 */
public class RequestData implements Parcelable {

    private static final int TYPE_BOOLEAN = 1;
    private static final int TYPE_BYTE = 2;
    private static final int TYPE_CHAR = 3;
    private static final int TYPE_SHORT = 4;
    private static final int TYPE_INT = 5;
    private static final int TYPE_LONG = 6;
    private static final int TYPE_FLOAT = 7;
    private static final int TYPE_DOUBLE = 8;
    private static final int TYPE_STRING = 9;
    private static final int TYPE_CHARSEQUENCE = 10;

    private int mRequestType = -1;
    private ArrayList<String> mParamList = new ArrayList<String>();
    private ArrayList<Integer> mTypeList = new ArrayList<Integer>();
    private Bundle mBundle = new Bundle();

    /**
     * Constructor
     *
     * @param requestType The request type.
     */
    public RequestData(int requestType) {
        mRequestType = requestType;
    }

    /**
     * Returns the request type.
     *
     * @return The request type.
     */
    public int getRequestType() {
        return mRequestType;
    }

    /**
     * Add a boolean parameter to the request, replacing any existing value for the given name.
     *
     * @param name The parameter name.
     * @param value The parameter value.
     * @return This RequestData.
     */
    public RequestData put(String name, boolean value) {
        cleanName(name);
        mParamList.add(name);
        mTypeList.add(TYPE_BOOLEAN);
        mBundle.putBoolean(name, value);
        return this;
    }

    /**
     * Add a byte parameter to the request, replacing any existing value for the given name.
     *
     * @param name The parameter name.
     * @param value The parameter value.
     * @return This RequestData.
     */
    public RequestData put(String name, byte value) {
        cleanName(name);
        mParamList.add(name);
        mTypeList.add(TYPE_BYTE);
        mBundle.putByte(name, value);
        return this;
    }

    /**
     * Add a char parameter to the request, replacing any existing value for the given name.
     *
     * @param name The parameter name.
     * @param value The parameter value.
     * @return This RequestData.
     */
    public RequestData put(String name, char value) {
        cleanName(name);
        mParamList.add(name);
        mTypeList.add(TYPE_CHAR);
        mBundle.putChar(name, value);
        return this;
    }

    /**
     * Add a short parameter to the request, replacing any existing value for the given name.
     *
     * @param name The parameter name.
     * @param value The parameter value.
     * @return This RequestData.
     */
    public RequestData put(String name, short value) {
        cleanName(name);
        mParamList.add(name);
        mTypeList.add(TYPE_SHORT);
        mBundle.putShort(name, value);
        return this;
    }

    /**
     * Add a int parameter to the request, replacing any existing value for the given name.
     *
     * @param name The parameter name.
     * @param value The parameter value.
     * @return This RequestData.
     */
    public RequestData put(String name, int value) {
        cleanName(name);
        mParamList.add(name);
        mTypeList.add(TYPE_INT);
        mBundle.putInt(name, value);
        return this;
    }

    /**
     * Add a long parameter to the request, replacing any existing value for the given name.
     *
     * @param name The parameter name.
     * @param value The parameter value.
     * @return This RequestData.
     */
    public RequestData put(String name, long value) {
        cleanName(name);
        mParamList.add(name);
        mTypeList.add(TYPE_LONG);
        mBundle.putLong(name, value);
        return this;
    }

    /**
     * Add a float parameter to the request, replacing any existing value for the given name.
     *
     * @param name The parameter name.
     * @param value The parameter value.
     * @return This RequestData.
     */
    public RequestData put(String name, float value) {
        cleanName(name);
        mParamList.add(name);
        mTypeList.add(TYPE_FLOAT);
        mBundle.putFloat(name, value);
        return this;
    }

    /**
     * Add a double parameter to the request, replacing any existing value for the given name.
     *
     * @param name The parameter name.
     * @param value The parameter value.
     * @return This RequestData.
     */
    public RequestData put(String name, double value) {
        cleanName(name);
        mParamList.add(name);
        mTypeList.add(TYPE_DOUBLE);
        mBundle.putDouble(name, value);
        return this;
    }

    /**
     * Add a String parameter to the request, replacing any existing value for the given name.
     *
     * @param name The parameter name.
     * @param value The parameter value.
     * @return This RequestData.
     */
    public RequestData put(String name, String value) {
        cleanName(name);
        mParamList.add(name);
        mTypeList.add(TYPE_STRING);
        mBundle.putString(name, value);
        return this;
    }

    /**
     * Add a CharSequence parameter to the request, replacing any existing value for the given name.
     *
     * @param name The parameter name.
     * @param value The parameter value.
     * @return This RequestData.
     */
    public RequestData put(String name, CharSequence value) {
        cleanName(name);
        mParamList.add(name);
        mTypeList.add(TYPE_CHARSEQUENCE);
        mBundle.putCharSequence(name, value);
        return this;
    }

    private void cleanName(String name) {
        if (mParamList.contains(name)) {
            final int index = mParamList.indexOf(name);
            mParamList.remove(index);
            mTypeList.remove(index);
            mBundle.remove(name);
        }
    }

    /**
     * Returns the value associated with the given name, or false if no mapping of the desired type
     * exists for the given name.
     *
     * @param name The parameter name.
     * @return A boolean value.
     */
    public boolean getBoolean(String name) {
        return mBundle.getBoolean(name);
    }

    /**
     * Returns the value associated with the given name, or (byte) 0 if no mapping of the desired
     * type exists for the given name.
     *
     * @param name The parameter name.
     * @return A byte value.
     */
    public byte getByte(String name) {
        return mBundle.getByte(name);
    }

    /**
     * Returns the value associated with the given name, or false if no mapping of the desired type
     * exists for the given name.
     *
     * @param name The parameter name.
     * @return A char value.
     */
    public char getChar(String name) {
        return mBundle.getChar(name);
    }

    /**
     * Returns the value associated with the given name, or (short) 0 if no mapping of the desired
     * type exists for the given name.
     *
     * @param name The parameter name.
     * @return A short value.
     */
    public short getShort(String name) {
        return mBundle.getShort(name);
    }

    /**
     * Returns the value associated with the given name, or 0 if no mapping of the desired type
     * exists for the given name.
     *
     * @param name The parameter name.
     * @return An int value.
     */
    public int getInt(String name) {
        return mBundle.getInt(name);
    }

    /**
     * Returns the value associated with the given name, or 0L if no mapping of the desired type
     * exists for the given name.
     *
     * @param name The parameter name.
     * @return A long value.
     */
    public long getLong(String name) {
        return mBundle.getLong(name);
    }

    /**
     * Returns the value associated with the given name, or 0.0f if no mapping of the desired type
     * exists for the given name.
     *
     * @param name The parameter name.
     * @return A float value.
     */
    public float getFloat(String name) {
        return mBundle.getFloat(name);
    }

    /**
     * Returns the value associated with the given name, or 0.0 if no mapping of the desired type
     * exists for the given name.
     *
     * @param name The parameter name.
     * @return A double value.
     */
    public double getDouble(String name) {
        return mBundle.getDouble(name);
    }

    /**
     * Returns the value associated with the given name, or null if no mapping of the desired type
     * exists for the given name.
     *
     * @param name The parameter name.
     * @return A String value.
     */
    public String getString(String name) {
        return mBundle.getString(name);
    }

    /**
     * Returns the value associated with the given name, or null if no mapping of the desired type
     * exists for the given name.
     *
     * @param name The parameter name.
     * @return A CharSequence value.
     */
    public CharSequence getCharSequence(String name) {
        return mBundle.getCharSequence(name);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof RequestData) {
            RequestData oParams = (RequestData) o;
            if (mParamList.size() != oParams.mParamList.size()) {
                return false;
            }

            for (int i = 0, length = mParamList.size(); i < length; i++) {
                String param = mParamList.get(i);
                if (!oParams.mParamList.contains(param)) {
                    return false;
                }

                int type = mTypeList.get(i);
                if (oParams.mTypeList.get(i) != type) {
                    return false;
                }

                switch (mTypeList.get(i)) {
                    case TYPE_BOOLEAN:
                        if (mBundle.getBoolean(param) != oParams.mBundle.getBoolean(param)) {
                            return false;
                        }
                        break;
                    case TYPE_BYTE:
                        if (mBundle.getByte(param) != oParams.mBundle.getByte(param)) {
                            return false;
                        }
                        break;
                    case TYPE_CHAR:
                        if (mBundle.getChar(param) != oParams.mBundle.getChar(param)) {
                            return false;
                        }
                        break;
                    case TYPE_SHORT:
                        if (mBundle.getShort(param) != oParams.mBundle.getShort(param)) {
                            return false;
                        }
                        break;
                    case TYPE_INT:
                        if (mBundle.getInt(param) != oParams.mBundle.getInt(param)) {
                            return false;
                        }
                        break;
                    case TYPE_LONG:
                        if (mBundle.getLong(param) != oParams.mBundle.getLong(param)) {
                            return false;
                        }
                        break;
                    case TYPE_FLOAT:
                        if (mBundle.getFloat(param) != oParams.mBundle.getFloat(param)) {
                            return false;
                        }
                        break;
                    case TYPE_DOUBLE:
                        if (mBundle.getDouble(param) != oParams.mBundle.getDouble(param)) {
                            return false;
                        }
                        break;
                    case TYPE_STRING:
                        if (ObjectUtils.safeEquals(mBundle.getString(param),
                                oParams.mBundle.getString(param))) {
                            return false;
                        }
                        break;
                    case TYPE_CHARSEQUENCE:
                        if (ObjectUtils.safeEquals(mBundle.getCharSequence(param),
                                oParams.mBundle.getCharSequence(param))) {
                            return false;
                        }
                        break;
                    default:
                        // We should never arrive here normally.
                        throw new IllegalArgumentException(
                                "The type of the field is not a valid one");
                }
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        ArrayList<Object> objectList = new ArrayList<Object>();
        objectList.add(mRequestType);
        for (int i = 0, length = mParamList.size(); i < length; i++) {
            objectList.add(mBundle.get(mParamList.get(i)));
        }
        return objectList.hashCode();
    }

    // Parcelable management
    private RequestData(final Parcel in) {
        mRequestType = in.readInt();
        in.readStringList(mParamList);
        for (int i = 0, n = in.readInt(); i < n; i++) {
            mTypeList.add(in.readInt());
        }
        mBundle = in.readBundle();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mRequestType);
        dest.writeStringList(mParamList);
        dest.writeInt(mTypeList.size());
        for (int i = 0, length = mTypeList.size(); i < length; i++) {
            dest.writeInt(mTypeList.get(i));
        }
        dest.writeParcelable(mBundle, flags);
    }

    public static final Creator<RequestData> CREATOR = new Creator<RequestData>() {
        public RequestData createFromParcel(final Parcel in) {
            return new RequestData(in);
        }

        public RequestData[] newArray(final int size) {
            return new RequestData[size];
        }
    };
}