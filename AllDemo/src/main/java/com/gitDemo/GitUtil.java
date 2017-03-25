package com.gitDemo;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.PullResult;
import org.eclipse.jgit.api.Status;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.dircache.DirCache;
import org.eclipse.jgit.internal.storage.file.FileRepository;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by sunchong on 2017/1/22.
 */
public class GitUtil{

    public static Git createGit(String path) throws IOException{
        Repository repository = new FileRepository(path+"/.git");
        if(repository.getObjectDatabase().exists()){
            return new Git(repository);
        }
        return new Git(createRepository(path));
    }

    public static Repository createRepository(String path) throws IOException{
        Repository repository = new FileRepository(path+"/.git");
        repository.create();
        return repository;
    }

    public static List<String> getAllBranch(Git git) throws GitAPIException{
        List<String> retList = new ArrayList<String>();
        List<Ref> refs = git.branchList().call();

        for(Ref ref : refs){
            System.out.println("ref_name:" + ref.getName());
            retList.add(ref.getName());
        }
        return retList;
    }

    public static String getCurrentBranch(Git git) throws IOException{
        Repository repository = git.getRepository();
        return repository.getBranch();
    }

    public static List<String> getCommitHistory(Git git) throws Exception{
        List<String> retList = new ArrayList<String>();
        Iterator iterator = git.log().call().iterator();
        while (iterator.hasNext()){
            String log = (String)iterator.next();
            System.out.println("log:"+iterator.next());
            retList.add(log);

        }
        return retList;
    }

    public static void getRemotePull(Git git) throws GitAPIException{
        PullResult pullResult = git.pull().call();
        if(pullResult.isSuccessful()){
            System.out.println("pull is success");
        }else{
            System.out.println("pull is fail");
        }
    }

    public static void getRemotePush(Git git, String commitText) throws GitAPIException{
        Status status = git.status().call();
        DirCache dirCache = git.add().call();
        RevCommit revCommit = git.commit().setMessage(commitText).call();
        git.push().call();
    }


}
