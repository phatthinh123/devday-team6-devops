package com.axonactive.devdayapp.dto;

/**
 * Request for comment
 *
 * @author dqlinh
 * @version $Revision:  $
 */
public class RequestComment {

    private Long parentId;
    private String comment;



    /**
     * Gets the comment
     *
     * @return Returns the comment
     */
    public String getComment()
    {
        return comment;
    }

    /**
     * Sets the comment
     *
     * @param comment The comment to set
     */
    public void setComment(String comment)
    {
        this.comment = comment;
    }

    /**
     * Gets the parentId
     *
     * @return Returns the parentId
     */
    public Long getParentId()
    {
        return parentId;
    }

    /**
     * Sets the parentId
     *
     * @param parentId The parentId to set
     */
    public void setParentId(Long parentId)
    {
        this.parentId = parentId;
    }
}

