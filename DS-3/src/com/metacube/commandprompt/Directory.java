package com.metacube.commandprompt;

import java.util.ArrayList;
import java.util.Date;

/**
 * This holds the structure and functionalities of a directory
 * @author Ayush Pandey
 *
 */
public class Directory {
	private Directory parent;
	private String name;
	private Date created;
	private ArrayList<Directory> subDirs;

	/**
	 * Initialize a Dir
	 * @param parent of dir
	 * @param name of dir
	 * @param created on date
	 */
	public Directory(Directory parent, String name, Date created) {
		this.parent = parent;
		this.name = name;
		this.created = created;
		this.subDirs = new ArrayList<Directory>();
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public ArrayList<Directory> getSubDirs() {
		return subDirs;
	}
	public void setSubDirs(ArrayList<Directory> subDirs) {
		this.subDirs = subDirs;
	}

	/**
	 * To check if has any child dir
	 * @return true if present
	 */
	public boolean hasSubDir() {
		if(subDirs.size() > 0)
			return true;
		return false;
	}

	/**
	 * To check if SubDir is present
	 * @param name of subDir
	 * @return true if present
	 */
	public boolean isSubDirPresent(String name) {
		for(Directory subDir : subDirs) {
			if(name.equals(subDir.getName())){
				return true;
			}
		}
		return false;
	}

	/**
	 * To get subDir of current dir
	 * @param name of subDir
	 * @return subDir
	 */
	public Directory getSubDir(String name) {
		for(Directory subDir: subDirs) {
			if(name.equalsIgnoreCase(subDir.name)) {
				return subDir;
			}
		}
		return null;
	}

	/**
	 * To change the current Dir
	 * @param name to be changed
	 * @return Dir
	 */
	public Directory cd(String name) {
		if(isSubDirPresent(name)){
			return getSubDir(name);
		} else {
			System.out.println("Directory Not Present.");
			return this;
		}
	}

	/**
	 * to create new Dir
	 * @param name of Dir
	 */
	public void mkDir(String name) {
		if(isSubDirPresent(name)){
			System.out.println("Name Already Exist.");
			return;
		}
		subDirs.add(new Directory(this,name, new Date()));
	}

	/**
	 * To get the path of searched Dir
	 * @param dir in which search is made
	 * @param name to be searched
	 * @param path to Dir
	 * @param paths final to Dir
	 * @return
	 */
	public ArrayList<String> findAllPaths(Directory dir , String name , String path, ArrayList<String> paths) {
		for(Directory subDir: dir.getSubDirs()) {
			if(subDir.getName().contains(name)) {
				paths.add(path +"\\"+subDir.getName());
			}
			findAllPaths(subDir , name , path+"\\"+subDir.getName(),paths);
		}
		return paths;
	}

	/**
	 * To find subDir in current Dir
	 * @param name of subDir
	 * @param path to be appended
	 */
	public void find(String name , String path) {
		ArrayList<String> paths = findAllPaths(this, name, path,
				new ArrayList<String>());
		for(String filePath : paths) {
			System.out.println(filePath);
		}
	}

	/**
	 * to change to parent Dir
	 * @return Dir
	 */
	public Directory back() {
		if(this.parent != null) 
			return this.parent;
		System.out.println("you are at root dir.");
		return this;
	}

	/**
	 * To show all SubDir present
	 */
	public void list() {
		for(Directory subDir : this.subDirs) {
			System.out.println(subDir.getCreated() + " " +subDir.getName());
		}
		System.out.println("Total Folder : "+this.subDirs.size());
	}

	/**
	 * To show tree structure of Subdir
	 * @param path
	 */
	public void tree(String path) {
		path = path + "-------";
		for(Directory subDir: this.subDirs) {
			System.out.println(path+" "+subDir.getName());
			subDir.tree(path);
		}

	}

}
