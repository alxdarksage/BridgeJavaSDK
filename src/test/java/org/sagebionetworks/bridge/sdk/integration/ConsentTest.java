package org.sagebionetworks.bridge.sdk.integration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sagebionetworks.bridge.sdk.TestUserHelper;
import org.sagebionetworks.bridge.sdk.TestUserHelper.TestUser;
import org.sagebionetworks.bridge.sdk.UserClient;

public class ConsentTest {

    private TestUser testUser;

    @Before
    public void before() {
        testUser = TestUserHelper.createAndSignInUser(ConsentTest.class, true);
    }

    @After
    public void after() {
        testUser.signOutAndDeleteUser();
    }

    @Test
    public void canToggleDataSharing() {
        UserClient client = testUser.getSession().getUserClient();

        client.suspendDataSharing();
        client.resumeDataSharing();
    }
}
/*
@Test
public void test() {
    running(testServer(3333), new TestUtils.FailableRunnable() {
        @Override
        public void testCode() throws Exception {

            // Helper's user is already consented, so consenting again should fail.
            Response giveConsentFail = TestUtils.getURL(testUser.getSessionToken(), CONSENT_URL).post("")
                    .get(TIMEOUT);
            assertEquals("give Consent fails with 400", SC_BAD_REQUEST, giveConsentFail.getStatus());

            // Consenting turns data sharing on by default, so check that we can suspend sharing.
            Response suspendDataSharing = TestUtils.getURL(testUser.getSessionToken(), SUSPEND_URL).post("")
                    .get(TIMEOUT);
            assertEquals("suspendDataSharing succeeds with 200", SC_OK, suspendDataSharing.getStatus());

            // We've suspended data sharing, now check to see if we can resume data sharing.
            Response resumeDataSharing = TestUtils.getURL(testUser.getSessionToken(), RESUME_URL).post("")
                    .get(TIMEOUT);
            assertEquals("resumeDataSharing succeeds with 200", SC_OK, resumeDataSharing.getStatus());

            // Resume data sharing should be idempotent.
            resumeDataSharing = TestUtils.getURL(testUser.getSessionToken(), RESUME_URL).post("").get(TIMEOUT);
            assertEquals("resumeDataSharing succeeds with 200", SC_OK, resumeDataSharing.getStatus());

            TestUser otherUser = null;
            try {
                otherUser = helper.createUser(ConsentControllerTest.class, true, false);
                
                // Consent new user again
                ObjectNode node = JsonNodeFactory.instance.objectNode();
                node.put("name", "John Smith");
                node.put("birthdate", DateUtils.getISODate((new DateTime()).minusYears(20)));

                Response giveConsentSuccess = TestUtils.getURL(otherUser.getSessionToken(), CONSENT_URL)
                        .post(node.toString()).get(TIMEOUT);
                assertEquals("Give consent succeeds with 201", SC_CREATED, giveConsentSuccess.getStatus());
            } finally {
                helper.deleteUser(otherUser);
            }
        }
    });
}
*/