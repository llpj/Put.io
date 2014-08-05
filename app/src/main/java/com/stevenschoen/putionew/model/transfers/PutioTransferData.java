package com.stevenschoen.putionew.model.transfers;

import android.os.Parcel;
import android.os.Parcelable;

public class PutioTransferData implements Parcelable {
	public int id;
	public int fileId;
	public long size;
	public String name;
	public String estimatedTime;
	public String createdTime;
	public boolean extract;
    public String currentRatio;
	public long downSpeed;
	public long upSpeed;
	public int percentDone;
	public String status;
	public String statusMessage;
	public int saveParentId;

    @Override
	public int describeContents() {
		return 0;
	}
	
	public PutioTransferData(Parcel in) {
		readFromParcel(in);
	}
	
	private void readFromParcel(Parcel in) {
		this.id = in.readInt();
		this.fileId = in.readInt();
		this.size = in.readLong();
		this.name = in.readString();
		this.estimatedTime = in.readString();
		this.createdTime = in.readString();
		this.extract = (Boolean) in.readValue(ClassLoader.getSystemClassLoader());
        this.currentRatio = in.readString();
		this.downSpeed = in.readLong();
		this.upSpeed = in.readLong();
		this.percentDone = in.readInt();
		this.status = in.readString();
		this.statusMessage = in.readString();
		this.saveParentId = in.readInt();
	}

	@Override
	public void writeToParcel(Parcel out, int flags) {
		out.writeInt(this.id);
		out.writeInt(this.fileId);
		out.writeLong(this.size);
		out.writeString(this.name);
		out.writeString(this.estimatedTime);
		out.writeString(this.createdTime);
		out.writeValue(this.extract);
        out.writeString(this.currentRatio);
		out.writeLong(this.downSpeed);
		out.writeLong(this.upSpeed);
		out.writeInt(this.percentDone);
		out.writeString(this.status);
		out.writeString(this.statusMessage);
		out.writeInt(this.saveParentId);
	}
	
	public static final Creator CREATOR = new Creator() {
		public PutioTransferData createFromParcel(Parcel in) {
			return new PutioTransferData(in);
		}

		public PutioTransferData[] newArray(int size) {
			return new PutioTransferData[size];
		}
	};
}