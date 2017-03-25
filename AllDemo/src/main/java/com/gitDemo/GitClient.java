package com.gitDemo;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;

import java.io.IOException;

/**
 * Created by sunchong on 2017/1/22.
 */
public class GitClient{

    public static void main(String[] args){
        try{
            Git git = GitUtil.createGit("E:\\code\\ITS");
            System.out.println(GitUtil.getCurrentBranch(git));
            GitUtil.getAllBranch(git);
            GitUtil.getCommitHistory(git);
        }catch (IOException e){
            e.printStackTrace();
        }catch (GitAPIException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
