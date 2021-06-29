package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupHelper extends HelperBase {

    public GroupHelper(WebDriver wd) {
        super(wd);
    }

    public void submitGroupCreation(String submit) {
        click(By.name(submit));
    }

    public void fillGroupForm(GroupData groupData) {
        type(getGroup_name(), groupData.getName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
    }

    private By getGroup_name() {
        return By.name("group_name");
    }

    public void initGroupCreation(String s) {
        click(By.name(s));
    }

    public void returnToGroupPage() {
        click(By.linkText("groups"));
    }

    public void deleteSelectedGroups() {
        click(By.name("delete"));
    }

    public void selectGroup() {
        click(By.name("selected[]"));
    }

    public void initGroupModification() {
        click(By.name("edit"));
    }

    public void submitGroupModification() {
        click(By.name("update"));
    }
}
