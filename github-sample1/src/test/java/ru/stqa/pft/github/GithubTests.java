package ru.stqa.pft.github;

import com.google.common.collect.ImmutableMap;
import com.jcabi.github.*;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by Boris on 09.05.2017.
 */
public class GithubTests {

  @Test
  public void testCommits() throws IOException {
    Github github = new RtGithub("32537cfc53072388a9280bc792043f82b48a55c5");
    RepoCommits commits = github.repos().get(new Coordinates.Simple("iboris1", "java_pft")).commits();
    for (RepoCommit commit : commits.iterate(new ImmutableMap.Builder<String,String>().build())){
      System.out.println(new RepoCommit.Smart(commit).message());

    }

  }


}
