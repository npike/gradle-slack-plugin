package com.mindera.gradle.slack.utils

/**
 * Created by joaoprudencio on 06/05/15.
 */
class GitUtils {

    public static String branchName() {
        def workingBranch = "git branch | grep \\* | cut -d ' ' -f2".execute().text.trim()
        return workingBranch
    }

    public static String tagName() {
        def workingBranch = "git tag --points-at HEAD".execute().text.trim()
        return workingBranch
    }

    public static String tagNameOrBranchName() {
        return tagName() ?: branchName()
    }

    public static String lastCommitAuthor() {
        def lastCommitAuthor = "git log -1 --pretty=%ce".execute().text.trim()
        return lastCommitAuthor
    }

    public static String lastCommitMessage() {
        def message = "git log -1 --pretty=%B".execute().text.trim()
        return message
    }
}
