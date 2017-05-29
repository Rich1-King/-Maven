package com.sshdemo;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;

/**
 * Created by rich1 on 5/29/17.
 */
public class Client{

    public static void main(String[] args) throws JSchException, IOException{
        JSch jSch = new JSch();
        String userName = "";
        String password = "";
        String host = "";
        int port = 0;
        String cmd = "ls";
        Session session = jSch.getSession(userName, host, port);
        session.setPassword(password);
        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config);

        int timeout = 6000000;
        session.setTimeout(timeout);

        session.connect();

        ChannelExec channelExec = (ChannelExec) session.openChannel("exec");
        channelExec.setCommand(cmd);
        channelExec.setInputStream(null);
        channelExec.setErrStream(System.err);
        channelExec.connect();

        InputStream in = channelExec.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in, Charset.forName("UTF-8")));
        String buf = null;
        StringBuffer sb = new StringBuffer();
        while ((buf = reader.readLine()) != null) {
            sb.append(buf);
            System.out.println(buf);// 打印控制台输出
        }
        reader.close();
        channelExec.disconnect();
        if (null != session) {
            session.disconnect();
        }

    }

}
